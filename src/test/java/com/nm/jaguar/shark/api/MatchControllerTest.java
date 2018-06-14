package com.nm.jaguar.shark.api;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nm.jaguar.shark.JaguarSharkApplication;
import com.nm.jaguar.shark.mongo.data.ExistingLunchMatches;
import com.nm.jaguar.shark.mongo.data.LunchMatch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JaguarSharkApplication.class)
public class MatchControllerTest {
	
	@Autowired
	MatchController controller;
	
	@Test
	public void getUserInfoTest() {
		
		LunchMatch user = controller.getUserInfo("zis31");
		
		System.out.println("getUserInfoTest: " + user);
		
		assertNotNull("getUserInfoTest: No results were returned - ", user);
	}
	
	@Test
	public void findMatchesTest() {

		MatchRequest requestBody = new MatchRequest();
		
		List<LocalDate> dates = new ArrayList<>();
		
		dates.add(LocalDate.parse("2018-06-15"));
		dates.add(LocalDate.parse("2018-06-18"));
		
		requestBody.setAvailableDays(dates);
		requestBody.setFirstName("Steve");
		requestBody.setLastName("Zissou");
		requestBody.setLanID("zis31");
		
		ExistingLunchMatches matchMap = controller.findMatches(requestBody, "zis31");
		
		System.out.println("findMatchesTest: " + matchMap.getMatchesByDate().toString());
		
		assertNotNull("findMatchesTest: No results were returned - ", matchMap);
	}
}
