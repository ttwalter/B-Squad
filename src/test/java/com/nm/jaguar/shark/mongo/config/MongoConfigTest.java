package com.nm.jaguar.shark.mongo.config;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nm.jaguar.shark.JaguarSharkApplication;
import com.nm.jaguar.shark.mongo.data.LunchMatch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JaguarSharkApplication.class)
public class MongoConfigTest {

	@Autowired
	MongoConfiguration mongoConfig;

	@Test
	public void getMatchByLanId() {

		LunchMatch match = mongoConfig.getLunchMatchByLanId("zis31");

		System.out.println("getMatchByLanId: " + match);

		assertNotNull("Query did not return any results: ", match);
	}

	@Test
	public void getMatchesByDateTest() {

		String dateStr = "2018-06-15";
		LocalDate date = LocalDate.parse(dateStr);

		List<LunchMatch> matches = mongoConfig.getLunchMatchesByDate(date);

		System.out.println("getMatchesByDateTest: " + matches);

		Assert.assertNotEquals("Query did not return any results: ", 0, matches.size());
	}
}
