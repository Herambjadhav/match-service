package com.dilmil.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "LIKES_DATA")
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String likedUserId;

	public Like() {
	}

	public Like(final String userId, final String likedUserId) {
		this.userId = userId;
		this.likedUserId = likedUserId;
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

	public String getLikedUserId() {
		return likedUserId;
	}

	public void setLikedUserId(String likedUserId) {
		this.likedUserId = likedUserId;
	}
}
