package com.dilmil.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.dilmil.model.Dislike;
import com.dilmil.model.Like;
import com.dilmil.model.User;

/*
 * Util's for applying different filters
 */

public class FilterUtils {

	public static List<User> applyAgeFilter(List<User> filteredUsers, ArrayList<?> values) {
		int startAge = (Integer) values.get(0);
		int endAge = (Integer) values.get(1);
		List<User> ageFiltered = new ArrayList<User>();
		filteredUsers.forEach(user -> {
			if (user.getAge() >= startAge && user.getAge() <= endAge) {
				ageFiltered.add(user);
			}
		});
		return ageFiltered;
	}

	public static List<User> applyLocationFilter(List<User> filteredUsers, ArrayList<?> values, boolean byCity) {
		String location = values.get(0).toString();
		List<User> locationFiltered = new ArrayList<>();
		filteredUsers.forEach(user -> {
			String userLocation = byCity ? user.getLocationData().getCity() : user.getLocationData().getCountry();
			if (userLocation.equalsIgnoreCase(location)) {
				locationFiltered.add(user);
			}
		});
		return locationFiltered;
	}

	public static List<User> applySexFilter(List<User> filteredUsers, ArrayList<?> values) {
		char sex = values.get(0).toString().charAt(0);
		List<User> sexFiltered = new ArrayList<>();
		filteredUsers.forEach(user -> {
			char userSex = user.getSex();
			if (userSex == sex) {
				sexFiltered.add(user);
			}
		});
		return sexFiltered;
	}

	public static List<User> filterLikedUsers(List<User> filteredUsers, List<Like> likes) {
		Set<String> userIdSet = new HashSet<String>();
		filteredUsers.forEach(user -> userIdSet.add(user.getUserId()));
		likes.forEach(like -> {
			if (userIdSet.contains(like.getLikedUserId())) {
				userIdSet.remove(like.getLikedUserId());
			}
		});
		filteredUsers = filteredUsers.stream().filter(user -> userIdSet.contains(user.getUserId()))
				.collect(Collectors.toList());
		return filteredUsers;
	}

	public static List<User> filterDislikedUsers(List<User> filteredUsers, List<Dislike> dislikes) {
		Set<String> userIdSet = new HashSet<String>();
		filteredUsers.forEach(user -> userIdSet.add(user.getUserId()));
		dislikes.forEach(like -> {
			if (userIdSet.contains(like.getDislikedUserId())) {
				userIdSet.remove(like.getDislikedUserId());
			}
		});
		filteredUsers = filteredUsers.stream().filter(user -> userIdSet.contains(user.getUserId()))
				.collect(Collectors.toList());
		return filteredUsers;
	}
}
