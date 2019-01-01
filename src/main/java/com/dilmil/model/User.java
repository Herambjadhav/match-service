package com.dilmil.model;

public class User {

	private String userId;
	private String name;
	private String about;
	private int age;
	private char sex;
	private LocationData locationData;

	public User() {
	}

	public User(String userId, String name, String about, int age, char sex, LocationData locationData) {
		super();
		this.userId = userId;
		this.name = name;
		this.about = about;
		this.age = age;
		this.sex = sex;
		this.locationData = locationData;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public LocationData getLocationData() {
		return locationData;
	}

	public void setLocationData(LocationData locationData) {
		this.locationData = locationData;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
}
