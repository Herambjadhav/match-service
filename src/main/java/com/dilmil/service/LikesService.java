package com.dilmil.service;

import java.util.List;

import com.dilmil.model.Like;

public interface LikesService {

	public List<Like> getAllLikes(String userId);

	public void saveLike(Like like);
}
