package com.dilmil.service;

import java.util.List;

import com.dilmil.model.Dislike;

public interface DislikesService {

	public List<Dislike> getAllDislikes(String userId);

	public void saveDislike(Dislike dislike);
}
