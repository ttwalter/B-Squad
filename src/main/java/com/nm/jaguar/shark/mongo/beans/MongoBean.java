package com.nm.jaguar.shark.mongo.beans;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;
import com.nm.jaguar.shark.util.SimpleMongo;

@Configuration
public class MongoBean {

	private final String HOST = "localhost";
	private final int PORT = 27017;
	private final String DATABASE = "fusion";

	private MongoClient mongoClient = new MongoClient(HOST, PORT);

	@Bean(name = "mongoDatabase")
	public MongoDatabase mongoClient() {

		// Build provider and registry to convert Bson to Pojo
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(pojoCodecProvider));

		// Accessing the database
		return mongoClient.getDatabase(DATABASE).withCodecRegistry(pojoCodecRegistry);
	}

	@Bean(name = "simpleMongo")
	public SimpleMongo simpleMongo() {
		return new SimpleMongo();
	}
}
