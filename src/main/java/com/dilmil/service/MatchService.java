package com.dilmil.service;

import java.util.List;

import com.dilmil.model.Filter;
import com.dilmil.model.Match;
import com.dilmil.model.User;

public interface MatchService {

	public List<Match> getAllMatches(String userId);

	public void saveMatch(Match match);

	public List<User> getPotentialMatches(String userId, List<Filter> filters);
}
