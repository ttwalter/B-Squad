package com.nm.jaguar.shark.mongo.data;

import org.bson.types.ObjectId;

public abstract class BaseEntity {
	
    protected ObjectId id;
 
    public BaseEntity() {
        super();
    }
 
    public ObjectId getId() {
        return id;
    }
 
    public void setId(ObjectId id) {
        this.id = id;
    }

}
