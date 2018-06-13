package com.nm.jaguar.shark.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nm.jaguar.shark.mongo.data.ExistingLunchMatches;
import com.nm.jaguar.shark.mongo.data.LunchMatch;

@RestController
public class MatchController {

	@RequestMapping(value="/GetUserInfo", method=RequestMethod.GET)
	public LunchMatch getUserInfo(@RequestParam("lanID") String lanID) {
		return populateUserInfo();
	}

	@RequestMapping(value = "/FindMatches", method = RequestMethod.POST)
	public ExistingLunchMatches findMatches(@RequestBody MatchRequest requestBody,
			@RequestParam("lanID") String landID) {
		System.out.println("Lan ID: " + requestBody.getLanID());
		System.out.println("First Name: " + requestBody.getFirstName());
		System.out.println("Last Name: " + requestBody.getLastName());
		return populateMockMatches();
	}

	@RequestMapping(value = "/FindExistingMatches", method = RequestMethod.GET)
	public ExistingLunchMatches findExistingMatches(@RequestParam("lanID") String lanID) {
		return populateMockMatches();
	}

	private LunchMatch populateUserInfo() {
		// Current User Info
		List<LocalDateTime> dates = new ArrayList<>();
		LocalDateTime current = LocalDateTime.now();
		LocalDateTime tomorrow = current.plusDays(1);
		dates.add(current);
		dates.add(tomorrow);

		LunchMatch currentUser = new LunchMatch();
		currentUser.setFirstName("Bill");
		currentUser.setLastName("Murray");
		currentUser.setLocation(1);
		currentUser.setDepartment("Digital Field Solutions");
		currentUser.setEmail("BillyBoy@yopmail.com");
		currentUser.setGrouping(1);
		currentUser.setTeamName("B-Squad");
		currentUser.setDates(dates);
		
		return currentUser;
	}

	private ExistingLunchMatches populateMockMatches() {
		ExistingLunchMatches existingMatches = new ExistingLunchMatches();

		// Current User Info
		List<LocalDateTime> dates = new ArrayList<>();
		LocalDateTime current = LocalDateTime.now();
		LocalDateTime tomorrow = current.plusDays(1);
		dates.add(current);
		dates.add(tomorrow);

		LunchMatch currentUser = new LunchMatch();
		currentUser.setFirstName("Bill");
		currentUser.setLastName("Murray");
		currentUser.setLocation(1);
		currentUser.setDepartment("Digital Field Solutions");
		currentUser.setEmail("BillyBoy@yopmail.com");
		currentUser.setGrouping(1);
		currentUser.setTeamName("B-Squad");
		currentUser.setDates(dates);

		// Match 1 Info
		List<LocalDateTime> match1Dates = new ArrayList<>();
		match1Dates.add(current);
		LunchMatch match1 = new LunchMatch();
		match1.setFirstName("Jaguar");
		match1.setLastName("Shark");
		match1.setLocation(1);
		match1.setDepartment("Digital Field Solutions");
		match1.setEmail("JagShark@yopmail.com");
		match1.setGrouping(1);
		match1.setTeamName("B-Squad");
		match1.setDates(match1Dates);

		// Match 2 Info
		List<LocalDateTime> match2Dates = new ArrayList<>();
		match2Dates.add(tomorrow);
		LunchMatch match2 = new LunchMatch();
		match2.setFirstName("Ned");
		match2.setLastName("Plimpton");
		match2.setLocation(1);
		match2.setDepartment("Digital Field Solutions");
		match2.setEmail("NedPlimpton@yopmail.com");
		match2.setGrouping(1);
		match2.setTeamName("B-Squad");
		match2.setDates(match2Dates);

		// Matches Map
		Map<LocalDateTime, List<LunchMatch>> matches = new HashMap<>();
		List<LunchMatch> day1Matches = new ArrayList<>();
		day1Matches.add(match1);
		List<LunchMatch> day2Matches = new ArrayList<>();
		day2Matches.add(match2);
		matches.put(current, day1Matches);
		matches.put(tomorrow, day2Matches);
		existingMatches.setCurrentUserInfo(currentUser);
		existingMatches.setMatchesByDate(matches);
		existingMatches.setLanID("mur1111");

		return existingMatches;

	}

}
