package com.rahul.booking.hotel.mongodb.pojo;

import org.bson.types.ObjectId;

import java.util.List;

public class Hotel extends AbstractDocument {
    private String name;
    private Double price;
    private Address address;
    private List<Review> reviewList;

    public Hotel() {
        super();
    }

    public Hotel(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}
