package com.nm.jaguar.shark.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class SimpleMongo {

	public <T> T findOneDocumentByAttribute(MongoDatabase database, Bson query, Class<T> pojoClass) {

		MongoCollection<T> collection = database.getCollection("lunch", pojoClass);

		System.out.println("Collection lunch selected successfully");

		return collection.find(query).first();
	}

	public <T> List<T> findManyByAttribute(MongoDatabase database, Bson query, Class<T> pojoClass) {

		MongoCollection<T> collection = database.getCollection("lunch", pojoClass);

		System.out.println("Collection lunch selected successfully");

		return collection.find().filter(query).into(new ArrayList<T>());

	}

}
