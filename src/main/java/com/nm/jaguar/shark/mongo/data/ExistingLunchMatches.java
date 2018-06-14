package com.nm.jaguar.shark.mongo.data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ExistingLunchMatches {
	
	private String lanID;
	private Map<LocalDate, List<LunchMatch>> matchesByDate;
	private LunchMatch currentUserInfo;
	
	
	public String getLanID() {
		return lanID;
	}
	public void setLanID(String lanID) {
		this.lanID = lanID;
	}
	public Map<LocalDate, List<LunchMatch>> getMatchesByDate() {
		return matchesByDate;
	}
	public void setMatchesByDate(Map<LocalDate, List<LunchMatch>> matchesByDate) {
		this.matchesByDate = matchesByDate;
	} 
	public LunchMatch getCurrentUserInfo() {
		return currentUserInfo;
	}
	public void setCurrentUserInfo(LunchMatch currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

}
