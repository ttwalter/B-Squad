package com.nm.jaguar.shark.mongo.data;

import java.time.LocalDate;
import java.util.Map;

public class ExistingLunchMatches {
	
	private String lanID;
	private Map<LocalDate, LunchMatch> matchesByDate;
	private LunchMatch currentUserInfo;
	
	
	public String getLanID() {
		return lanID;
	}
	public void setLanID(String lanID) {
		this.lanID = lanID;
	}
	public Map<LocalDate, LunchMatch> getMatchesByDate() {
		return matchesByDate;
	}
	public void setMatchesByDate(Map<LocalDate, LunchMatch> matchesByDate) {
		this.matchesByDate = matchesByDate;
	} 
	public LunchMatch getCurrentUserInfo() {
		return currentUserInfo;
	}
	public void setCurrentUserInfo(LunchMatch currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

}
