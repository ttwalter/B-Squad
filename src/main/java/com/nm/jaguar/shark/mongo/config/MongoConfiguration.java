package com.nm.jaguar.shark.mongo.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.Filters;
import com.nm.jaguar.shark.mongo.data.LunchMatch;
import com.nm.jaguar.shark.util.SimpleMongo;

@Component
@Service
public class MongoConfiguration {

	@Autowired
	private SimpleMongo<LunchMatch> simpleMongo;

	public LunchMatch getLunchMatchByLanId(String matchLanId) {

		return simpleMongo.findOneDocumentByAttribute(Filters.eq("lanId",matchLanId));
	}

	public List<LunchMatch> getLunchMatchesByDate(LocalDate date) {

		return simpleMongo.findManyByAttribute(Filters.gte("dates",date));
	}
}
