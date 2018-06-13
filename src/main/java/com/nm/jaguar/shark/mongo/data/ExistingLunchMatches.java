package com.nm.jaguar.shark.mongo.data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ExistingLunchMatches {
	
	private String lanID;
	private Map<LocalDateTime, List<LunchMatch>> matchesByDate;
	private LunchMatch currentUserInfo;
	
	
	public String getLanID() {
		return lanID;
	}
	public void setLanID(String lanID) {
		this.lanID = lanID;
	}
	public Map<LocalDateTime, List<LunchMatch>> getMatchesByDate() {
		return matchesByDate;
	}
	public void setMatchesByDate(Map<LocalDateTime, List<LunchMatch>> matchesByDate) {
		this.matchesByDate = matchesByDate;
	} 
	public LunchMatch getCurrentUserInfo() {
		return currentUserInfo;
	}
	public void setCurrentUserInfo(LunchMatch currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

}
