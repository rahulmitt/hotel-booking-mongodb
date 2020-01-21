package com.rahul.booking.hotel.mongodb.dao;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import com.rahul.booking.hotel.mongodb.util.converters.ConverterUtils;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HotelDao {

    @Autowired
    MongoClient mongoClient;

    private MongoCollection hotelsCollection;

    public HotelDao() {
        hotelsCollection = mongoClient.getDatabase("hotelsDB").getCollection("hotels");
    }

    public Hotel createHotel(Hotel hotel) {
        DBObject hotelDocument = ConverterUtils.toDBObject(hotel);
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
            while(cursor.hasNext()) {
                Document o = cursor.next();
                Hotel hotel = ConverterUtils.toHotel(o);
                hotelList.add(hotel);
            }
        } finally {
            cursor.close();
        }

        return hotelList;
    }
}
