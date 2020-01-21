package com.rahul.booking.hotel.mongodb.service;

import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    public HotelService hotelService;

    public List<Hotel> fetchAllHotels() {
        return  hotelService.fetchAllHotels();
    }
}
