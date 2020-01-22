package com.rahul.booking.hotel.mongodb.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import com.rahul.booking.hotel.mongodb.util.converters.ConverterUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HotelDao {

    private MongoCollection hotelsCollection;

    @Autowired
    public HotelDao(MongoClient mongoClient) {
        hotelsCollection = mongoClient.getDatabase("hotelsDB").getCollection("hotels");
    }

    public List<Hotel> createAllHotels(List<Hotel> hotelList) {
        List<Hotel> responseList = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            Hotel h = createHotel(hotel);
            responseList.add(h);
        }
        return responseList;
    }

    public Hotel createHotel(Hotel hotel) {
        Document hotelDocument = ConverterUtils.toDBObject(hotel);
        hotelsCollection.insertOne(hotelDocument);
        ObjectId id = (ObjectId) hotelDocument.get("_id");
        hotel.setId(id.toString());
        return hotel;
    }

    public List<Hotel> fetchAllHotels() {
        List<Hotel> hotelList = new ArrayList<>();
        FindIterable<Document> fi = hotelsCollection.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while (cursor.hasNext()) {
                Document o = cursor.next();
                Hotel hotel = ConverterUtils.toHotel(o);
                hotelList.add(hotel);
            }
        } finally {
            cursor.close();
        }

        return hotelList;
    }

    public void update() {
        //TODO:
    }

    public void dropHotelsCollection() {
        hotelsCollection.drop();
    }
}
