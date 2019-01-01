package com.dilmil.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilmil.model.Filter;
import com.dilmil.model.Match;
import com.dilmil.model.User;
import com.dilmil.service.MatchService;

@RestController
@RequestMapping("/match")
public class MatchWebService {

	@Autowired
	MatchService matchService;

	@GetMapping("/all/{userId}")
	public List<Match> getMatches(@PathVariable String userId) {
		return matchService.getAllMatches(userId);
	}

	@GetMapping("/candidates/{userId}")
	public List<User> getCandidates(@PathVariable String userId, @RequestBody List<Filter> filters) {
		return matchService.getPotentialMatches(userId, filters);
	}
}
