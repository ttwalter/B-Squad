package com.nm.jaguar.shark.api;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nm.jaguar.shark.mongo.config.MongoConfiguration;
import com.nm.jaguar.shark.mongo.data.ExistingLunchMatches;
import com.nm.jaguar.shark.mongo.data.LunchMatch;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class MatchController {

	@Autowired
	MongoConfiguration mongoConfig;

	@RequestMapping(value = "/GetUserInfo", method = RequestMethod.GET)
	public LunchMatch getUserInfo(@RequestParam("lanID") String lanID) {

		return mongoConfig.getLunchMatchByLanId(lanID);
	}

	@RequestMapping(value = "/FindMatches", method = RequestMethod.POST)
	public ExistingLunchMatches findMatches(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) MatchRequest requestBody,
			@RequestParam("lanID") String lanID) {

		System.out.println("Getting matches for Lan ID: " + requestBody.getLanID());

		ExistingLunchMatches existingMatches = new ExistingLunchMatches();
		existingMatches.setLanID(lanID);

		Map<LocalDate, List<LunchMatch>> matchMap = requestBody.getAvailableDays().stream()
				.collect(Collectors.toMap(Function.identity(), d -> mongoConfig.getLunchMatchesByDate(d)));

		Map<LocalDate, LunchMatch> randomMatchMap = new HashMap<>();
		
		for (LocalDate date : matchMap.keySet()) {
			
			randomMatchMap.put(date, matchMap.get(date).get(0));
		}
		
		existingMatches.setMatchesByDate(randomMatchMap);

		existingMatches.setCurrentUserInfo(getUserInfo(lanID));

		return existingMatches;
	}
}
