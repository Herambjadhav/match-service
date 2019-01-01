package com.dilmil.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dilmil.model.Dislike;

public interface DislikesRepository extends CrudRepository<Dislike, Long> {

	public List<Dislike> findByUserId(String userId);
}
