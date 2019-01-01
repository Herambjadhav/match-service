package com.dilmil.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String matchedUserId;

	public Match() {
	}

	public Match(final String userId, final String matchedUserId) {
		this.userId = userId;
		this.matchedUserId = matchedUserId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMatchedUserId() {
		return matchedUserId;
	}

	public void setMatchedUserId(String matchedUserId) {
		this.matchedUserId = matchedUserId;
	}
}
