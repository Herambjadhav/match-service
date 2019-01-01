package com.dilmil.model;

import java.util.ArrayList;

public class Filter {

	private FilterType type;
	private ArrayList<?> values = new ArrayList<>();

	public enum FilterType {
		AGE, CITY, COUNTRY, SEX;
	}

	public Filter() {
	}

	public Filter(FilterType type, ArrayList<?> values) {
		super();
		this.type = type;
		this.values = values;
	}

	public FilterType getType() {
		return type;
	}

	public void setType(FilterType type) {
		this.type = type;
	}

	public ArrayList<?> getValues() {
		return values;
	}

	public void setValues(ArrayList<?> values) {
		this.values = values;
	}
}
