package com.rahul.booking.hotel.mongodb.pojo;

import java.util.List;

public class Hotel extends AbstractDocument {
    private String name;
    private Double price;
    private Address address;
    private List<Review> reviewList;

    public Hotel() {
        super();
    }

    public Hotel(String name, Double price, Address address, List<Review> reviewList) {
        this.name = name;
        this.price = price;
        this.address = address;
        this.reviewList = reviewList;
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
