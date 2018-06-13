package com.nm.jaguar.shark.api;

import java.time.LocalDateTime;
import java.util.List;

public class MatchRequest {
	
	private String lanID;
	private String firstName;
	private String lastName;
	private List<LocalDateTime> availableDays;
	
	
	public String getLanID() {
		return lanID;
	}
	public void setLanID(String landID) {
		this.lanID = landID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<LocalDateTime> getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(List<LocalDateTime> availableDays) {
		this.availableDays = availableDays;
	}

}
