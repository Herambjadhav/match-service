package com.dilmil;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dilmil.model.Match;
import com.dilmil.model.Like;
import com.dilmil.repository.LikesRepository;
import com.dilmil.repository.MatchRepository;

@Configuration
public class LoadTestData {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadTestData.class);

	@Bean
	CommandLineRunner initLikeDatabase(LikesRepository likeRepository) {
		return args -> {
			LOGGER.info("Loading Likes Data...");
			List<Like> likes = new ArrayList<Like>();
			likes.add(new Like("bob@gmail.com", "alice@gmail.com"));
			likes.add(new Like("alice@gmail.com", "bob@gmail.com"));
			likes.forEach(like -> likeRepository.save(like));
		};
	}

	@Bean
	CommandLineRunner initMatchDatabase(MatchRepository matchRepository) {
		return args -> {
			LOGGER.info("Loading Match Data...");
			List<Match> matches = new ArrayList<Match>();
			matches.add(new Match("bob@gmail.com", "alice@gmail.com"));
			matches.forEach(match -> matchRepository.save(match));
		};
	}
}
