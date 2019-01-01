package com.dilmil.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dilmil.model.Like;

public interface LikesRepository extends CrudRepository<Like, Long> {

	public List<Like> findByUserId(String userId);

	public Like findByUserIdAndLikedUserId(String userId, String likedUserId);
}
