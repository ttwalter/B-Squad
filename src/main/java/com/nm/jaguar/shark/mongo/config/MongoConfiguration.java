package com.nm.jaguar.shark.mongo.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.nm.jaguar.shark.mongo.data.LunchMatch;
import com.nm.jaguar.shark.util.SimpleMongo;

@Component
@Service
public class MongoConfiguration {

	private MongoDatabase mongoDatabase;
	private SimpleMongo simpleMongo;

	@Autowired
	public MongoConfiguration(MongoDatabase mongoDatabase, SimpleMongo simpleMongo) {
		this.mongoDatabase = mongoDatabase;
		this.simpleMongo = simpleMongo;
	}

	public LunchMatch getLunchMatchByLanId(String matchLanId) {

		return simpleMongo.findOneDocumentByAttribute(mongoDatabase, 
														Filters.eq("lanId",matchLanId), 
														LunchMatch.class);
	}

	public List<LunchMatch> getLunchMatchesByDate(LocalDate date) {

		return simpleMongo.findManyByAttribute(mongoDatabase, 
												Filters.gte("dates",date), 
												LunchMatch.class);
	}
}
