package com.rahul.booking.hotel.mongodb.util.converters;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import org.bson.Document;
import org.bson.types.ObjectId;

public class ConverterUtils {
    public static DBObject toDBObject(Hotel hotel) {

        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", hotel.getName());

        if (hotel.getId() != null)
            builder = builder.append("_id", new ObjectId(hotel.getId()));

        return builder.get();
    }

    public static Hotel toHotel(Document document) {
        Hotel hotel = new Hotel();
        ObjectId id = (ObjectId) document.get("_id");
        hotel.setId(id.toString());

        hotel.setName((String) document.get("name"));
        return hotel;

    }
}
