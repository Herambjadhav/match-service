package com.dilmil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilmil.model.Dislike;
import com.dilmil.repository.DislikesRepository;

@Service
public class DislikesServiceImpl implements DislikesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DislikesService.class);

	@Autowired
	DislikesRepository dislikesRepository;

	public List<Dislike> getAllDislikes(String userId) {
		return dislikesRepository.findByUserId(userId);
	}

	public void saveDislike(Dislike dislike) {
		try {
			dislike.setUserId(dislike.getUserId().toLowerCase());
			dislike.setDislikedUserId(dislike.getDislikedUserId().toLowerCase());
			dislikesRepository.save(dislike);
			LOGGER.warn("{} Disiked {}", dislike.getUserId(), dislike.getDislikedUserId());
		} catch (Exception exception) {
			LOGGER.error("error while saving dislike : {}", exception);
		}
	}

}
