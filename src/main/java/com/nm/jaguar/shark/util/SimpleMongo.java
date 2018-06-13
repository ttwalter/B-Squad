package com.nm.jaguar.shark.util;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class SimpleMongo {

	
	public <T, D> T findOneDocumentByAttribute(MongoDatabase database, String key, D value, Class<T> pojoClass) {
		
		MongoCollection<T> collection = database.getCollection("lunch", pojoClass);

		System.out.println("Collection lunch selected successfully");

		return collection.find(Filters.eq(key, value)).first();
	}
	
	public <T,D> List<T> findManyByAttribute(MongoDatabase database, String key, D value, Class<T> pojoClass) {
		
		MongoCollection<T> collection = database.getCollection("lunch", pojoClass);

		System.out.println("Collection lunch selected successfully");

		return collection.find(Filters.gte(key, value)).into(new ArrayList<T>());
	}
	
}
