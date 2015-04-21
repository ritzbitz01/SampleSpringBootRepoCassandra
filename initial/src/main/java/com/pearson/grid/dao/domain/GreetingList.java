package com.pearson.grid.dao.domain;

import java.util.ArrayList;
import java.util.List;

public class GreetingList {
	
	List<Greeting> greetings;

	public GreetingList() {
		greetings = new ArrayList<>();
	}
	
	public void setGreetings(List<Greeting> greetings) {
		this.greetings = greetings;
	}
	
	public List<Greeting> getGreetings() {
		return greetings;
	}
}
