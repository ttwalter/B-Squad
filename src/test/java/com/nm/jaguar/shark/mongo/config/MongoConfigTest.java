package com.nm.jaguar.shark.mongo.config;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;


public class MongoConfigTest {
	
	
	//@Test
	public void mongoConfigTest() {

		MongoLunchConfiguration config = new MongoLunchConfiguration();

		System.out.println(config.getLunchMatchByLanId("ZIS123"));
	}
	
	@Test
	public void mongoConfigTest2() {

		MongoLunchConfiguration config = new MongoLunchConfiguration();

		String dateStr = "2016-06-22";

        LocalDate date = LocalDate.parse(dateStr);

		
		System.out.println("---->" + config.getLunchMatchesByDate(date));
				
	}


}
