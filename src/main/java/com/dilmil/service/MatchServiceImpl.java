package com.dilmil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilmil.model.Dislike;
import com.dilmil.model.Filter;
import com.dilmil.model.Like;
import com.dilmil.model.Match;
import com.dilmil.model.User;
import com.dilmil.repository.MatchRepository;
import com.dilmil.util.FilterUtils;

@Service
public class MatchServiceImpl implements MatchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MatchService.class);

	@Autowired
	MatchRepository matchRepository;

	@Autowired
	LocationServiceApi locationServiceApi;

	@Autowired
	LikesService likesService;

	@Autowired
	DislikesService dislikesService;

	public List<Match> getAllMatches(String userId) {
		return matchRepository.findByUserIdOrMatchedUserId(userId, userId);
	}

	public void saveMatch(Match match) {
		try {
			matchRepository.save(match);
		} catch (Exception exception) {
			LOGGER.error("error while saving match : {}", exception);
		}
	}

	@Override
	public List<User> getPotentialMatches(String userId, List<Filter> filters) {
		List<User> filteredUsers = locationServiceApi.getUsers(filters);
		List<Like> likes = likesService.getAllLikes(userId);
		List<Dislike> dislikes = dislikesService.getAllDislikes(userId);
		LOGGER.info("likes : {}", likes);
		LOGGER.info("dislikes : {}", dislikes);
		// Filter already liked users
		filteredUsers = FilterUtils.filterLikedUsers(filteredUsers, likes);
		LOGGER.info("Filtered after removing likes : {}", filteredUsers);
		// filter already disliked users
		filteredUsers = FilterUtils.filterDislikedUsers(filteredUsers, dislikes);
		LOGGER.info("Filtered after removing dislikes : {}", filteredUsers);
		return filteredUsers;
	}

}
