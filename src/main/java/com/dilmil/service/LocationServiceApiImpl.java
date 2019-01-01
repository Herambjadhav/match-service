package com.dilmil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dilmil.model.Filter;
import com.dilmil.model.LocationData;
import com.dilmil.model.User;
import com.dilmil.util.FilterUtils;

@Service
public class LocationServiceApiImpl implements LocationServiceApi {

	private static final List<User> USER_DATA = new ArrayList<User>();
	
	/*
	 * Static data representing Sample data response from a LocationService
	 */

	static {
		LocationData sf = new LocationData("San Francisco", "USA");
		LocationData sj = new LocationData("San Jose", "USA");
		LocationData oak = new LocationData("Oakland", "USA");
		LocationData mum = new LocationData("Mumbai", "IND");

		USER_DATA.add(new User("bob@gmail.com", "bob", "am cool", 25, 'M', sf));
		USER_DATA.add(new User("alice@gmail.com", "alice", "am cool", 22, 'F', sf));
		USER_DATA.add(new User("eve@gmail.com", "eve", "am cool", 28, 'M', sf));
		USER_DATA.add(new User("bilbo@gmail.com", "bilbo", "am cool", 30, 'M', sj));
		USER_DATA.add(new User("gandalf@gmail.com", "gandal", "am cool", 29, 'M', sj));
		USER_DATA.add(new User("galadrel@gmail.com", "galadrel", "am cool", 25, 'F', sj));
		USER_DATA.add(new User("frodo@gmail.com", "frodo", "am cool", 20, 'M', sf));
		USER_DATA.add(new User("elf@gmail.com", "elf", "am cool", 19, 'F', sf));
		USER_DATA.add(new User("harry@gmail.com", "harry", "am cool", 27, 'M', oak));
		USER_DATA.add(new User("hari@gmail.com", "hari", "am cool", 24, 'M', mum));

	}

	@Override
	public List<User> getUsers(List<Filter> filters) {
		/*
		 * STUB Implementation. Should Ideally be calling location-service over REST
		 */
		List<User> filteredUsers = USER_DATA;
		if (filters != null && !filters.isEmpty()) {
			for (Filter filter : filters) {
				filteredUsers = applyFilter(filter, filteredUsers);
			}
		}
		return filteredUsers;
	}

	private List<User> applyFilter(Filter filter, List<User> filteredUsers) {
		switch (filter.getType()) {
		case AGE:
			filteredUsers = FilterUtils.applyAgeFilter(filteredUsers, filter.getValues());
			break;
		case CITY:
			filteredUsers = FilterUtils.applyLocationFilter(filteredUsers, filter.getValues(), true);
			break;
		case COUNTRY:
			filteredUsers = FilterUtils.applyLocationFilter(filteredUsers, filter.getValues(), false);
			break;
		case SEX:
			filteredUsers = FilterUtils.applySexFilter(filteredUsers, filter.getValues());
			break;
		}
		return filteredUsers;
	}

}
