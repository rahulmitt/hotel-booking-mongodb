package com.rahul.booking.hotel.mongodb.pojo;

import org.bson.types.ObjectId;

public abstract class AbstractDocument {

    protected String id;

    public AbstractDocument() {
    }

    public AbstractDocument(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
