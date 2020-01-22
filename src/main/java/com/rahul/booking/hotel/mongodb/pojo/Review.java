package com.rahul.booking.hotel.mongodb.pojo;

public class Review extends AbstractDocument {
    private String username;
    private Rating rating;
    private boolean approved;

    public Review() {
    }

    public Review(String username, Rating rating, boolean approved) {
        super();
        this.username = username;
        this.rating = rating;
        this.approved = approved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
