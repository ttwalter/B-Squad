package com.nm.jaguar.shark.mongo.beans;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.nm.jaguar.shark.mongo.data.LunchMatch;
import com.nm.jaguar.shark.util.SimpleMongo;

@Configuration
public class MongoBean {

	private final String HOST = "localhost";
	private final int PORT = 27017;
	private final String DATABASE = "fusion";
	private final String COLLECTION = "lunch";

	private MongoClient mongoClient = new MongoClient(HOST, PORT);

	@Bean(name = "mongoDatabase")
	public MongoDatabase mongoDatabase() {

		// Build provider and registry to convert Bson to Pojo
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(pojoCodecProvider));

		// Accessing the database
		return mongoClient.getDatabase(DATABASE).withCodecRegistry(pojoCodecRegistry);
	}

	@Bean(name = "simpleMongo")
	public SimpleMongo<LunchMatch> simpleMongo() {
		return new SimpleMongo<>();
	}

	@Bean(name = "mongoCollection")
	public MongoCollection<LunchMatch> mongoCollection(@Autowired MongoDatabase mongoDatabase) {
		return mongoDatabase.getCollection(COLLECTION, LunchMatch.class);
	}
	
	@Bean
	public Formatter<LocalDate> localDateFormatter() {
	  return new Formatter<LocalDate>() {
	    @Override
	    public LocalDate parse(String text, Locale locale) throws ParseException {
	      return LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
	    }
	 
	    @Override
	    public String print(LocalDate object, Locale locale) {
	      return DateTimeFormatter.ISO_DATE.format(object);
	    }


	  };
	}
}
