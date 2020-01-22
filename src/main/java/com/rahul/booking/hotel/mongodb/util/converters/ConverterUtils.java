package com.rahul.booking.hotel.mongodb.util.converters;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.rahul.booking.hotel.mongodb.pojo.Address;
import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import com.rahul.booking.hotel.mongodb.pojo.Rating;
import com.rahul.booking.hotel.mongodb.pojo.Review;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtils {
    public static Document toDBObject(Hotel hotel) {

        DBObject address = BasicDBObjectBuilder.start()
                .append("city", hotel.getAddress().getCity())
                .append("country", hotel.getAddress().getCountry())
                .get();

        List<DBObject> reviewList = new ArrayList<>();
        for (Review r : hotel.getReviewList()) {
            DBObject review = BasicDBObjectBuilder.start()
                    .append("username", r.getUsername())
                    .append("rating", r.getRating().name())
                    .append("approved", r.isApproved())
                    .get();
            reviewList.add(review);
        }

        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
                .append("name", hotel.getName())
                .append("price", hotel.getPrice())
                .append("address", address)
                .append("reviews", reviewList);

        if (hotel.getId() != null) builder = builder.append("_id", new ObjectId(hotel.getId()));
        return new Document(builder.get().toMap());
    }

    public static Hotel toHotel(Document document) {

        Address address = new Address();
        Document addressDocument = (Document) document.get("address");
        address.setCity(addressDocument.getString("city"));
        address.setCountry(addressDocument.getString("country"));

        List<Review> reviewList = new ArrayList<>();
        List<Document> reviewDocumentList = (List<Document>) document.get("reviews");
        for (Document reviewDocument : reviewDocumentList) {
            Review review = new Review();
            review.setUsername(reviewDocument.getString("username"));
            review.setRating(Rating.valueOf(reviewDocument.getString("rating")));
            review.setApproved(reviewDocument.getBoolean("approved"));
            reviewList.add(review);
        }

        Hotel hotel = new Hotel();
        ObjectId id = (ObjectId) document.get("_id");
        hotel.setId(id.toString());
        hotel.setName(document.getString("name"));
        hotel.setPrice(document.getDouble("price"));
        hotel.setAddress(address);
        hotel.setReviewList(reviewList);
        return hotel;
    }
}
