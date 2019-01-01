package com.dilmil.model;

public class LocationData {

	private String city;
	private String Country;

	public LocationData() {
	}

	public LocationData(String city, String country) {
		super();
		this.city = city;
		Country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}
