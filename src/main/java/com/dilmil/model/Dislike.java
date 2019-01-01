package com.dilmil.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "DISLIKES_DATA")
public class Dislike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String dislikedUserId;

	public Dislike() {
	}

	public Dislike(final String userId, final String dislikedUserId) {
		this.userId = userId;
		this.dislikedUserId = dislikedUserId;
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

	public String getDislikedUserId() {
		return dislikedUserId;
	}

	public void setDislikedUserId(String dislikedUserId) {
		this.dislikedUserId = dislikedUserId;
	}

}
