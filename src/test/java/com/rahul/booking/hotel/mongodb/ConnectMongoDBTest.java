package com.rahul.booking.hotel.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConnectMongoDBTest {
    Logger logger = LoggerFactory.getLogger(ConnectMongoDBTest.class);

    @Test
    public void testConnect() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        String dbName = "myUserDb";
        MongoDatabase mdb = mongoClient.getDatabase(dbName);
        logger.info("{} Database created", dbName);

        mdb.drop();
        mdb.getCollection("userDetails").insertOne(
                new Document()
                        .append("Name", "Rahul")
                        .append("city", "Mumbai")
        );

    }
}
