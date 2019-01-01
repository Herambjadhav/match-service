package com.dilmil.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dilmil.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {

	public List<Match> findByUserId(String userId);

	public List<Match> findByUserIdOrMatchedUserId(String userId, String matchedUserId);
}
