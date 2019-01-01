package com.dilmil.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dilmil.model.Dislike;

/*
 * Spring's CrudRepository to abstract away specific of underlying DB
 */

public interface DislikesRepository extends CrudRepository<Dislike, Long> {

	public List<Dislike> findByUserId(String userId);
}
