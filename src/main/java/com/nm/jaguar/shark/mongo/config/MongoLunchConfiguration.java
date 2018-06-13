package com.nm.jaguar.shark.mongo.config;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.time.LocalDate;
import java.util.List;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;
import com.nm.jaguar.shark.mongo.data.LunchMatch;
import com.nm.jaguar.shark.util.SimpleMongo;

@Component
public class MongoLunchConfiguration {

	// TO-DO if time: add spring
//	@Autowired
//	MongoClient mongoClient;
	
	MongoClient mongo = new MongoClient("localhost", 27017);

	// TO-DO if time: add spring
	// Build provider and registry to convert Bson to Pojo
	CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
	CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
			fromProviders(pojoCodecProvider));

	// TO-DO if time: add spring
	// Accessing the database
	MongoDatabase database = mongo.getDatabase("fusion").withCodecRegistry(pojoCodecRegistry);
	
	// TO-DO if time: add spring
	SimpleMongo mg = new SimpleMongo();

	public LunchMatch getLunchMatchByLanId(String matchLanId) {

		return mg.findOneDocumentByAttribute(database, "lanId", matchLanId, LunchMatch.class);

	}
	
	public List<LunchMatch> getLunchMatchesByDate(LocalDate date) {

		return mg.findManyByAttribute(database, "dates", date, LunchMatch.class);

	}
	
	
}
