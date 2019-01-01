package com.dilmil.service;

import java.util.List;

import com.dilmil.model.Filter;
import com.dilmil.model.User;

public interface LocationServiceApi {

	public List<User> getUsers(List<Filter> filters);
}
