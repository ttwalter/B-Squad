package com.nm.jaguar.shark.util;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.client.MongoCollection;

public class SimpleMongo <T>{
	
	@Autowired
	MongoCollection<T> mongoCollection;

	public T findOneDocumentByAttribute(Bson query) {

		System.out.println("Mongo Query to return one document: " + query.toString());

		return mongoCollection.find(query).first();
	}

	public List<T> findManyByAttribute(Bson query) {

		System.out.println("Mongo Query to return many documents: " + query.toString());

		return mongoCollection.find().filter(query).into(new ArrayList<T>());
	}
}
