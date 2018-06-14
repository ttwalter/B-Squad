package com.nm.jaguar.shark.api;

import java.time.LocalDate;
import java.util.List;

public class MatchRequest {
	
	private String lanID;
	private List<LocalDate> availableDays;
	
	
	public String getLanID() {
		return lanID;
	}
	public void setLanID(String landID) {
		this.lanID = landID;
	}
	public List<LocalDate> getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(List<LocalDate> availableDays) {
		this.availableDays = availableDays;
	}

}
