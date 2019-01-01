package com.dilmil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilmil.model.Like;
import com.dilmil.model.Match;
import com.dilmil.repository.LikesRepository;

@Service
public class LikesServiceImpl implements LikesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LikesService.class);

	@Autowired
	LikesRepository likesRepository;

	@Autowired
	MatchService matchService;

	public List<Like> getAllLikes(String userId) {
		return likesRepository.findByUserId(userId);
	}

	public void saveLike(Like like) {
		try {
			like.setUserId(like.getUserId().toLowerCase());
			like.setLikedUserId(like.getLikedUserId().toLowerCase());
			likesRepository.save(like);
			// Check if user is also liked by likedUser
			Like isLiked = likesRepository.findByUserIdAndLikedUserId(like.getUserId(), like.getLikedUserId());
			if (isLiked != null) {
				// create match
				Match match = new Match(like.getUserId(), like.getLikedUserId());
				matchService.saveMatch(match);
			}

		} catch (Exception exception) {
			LOGGER.error("error while saving like : {}", exception);
		}

	}
}
