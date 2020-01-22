package com.rahul.booking.hotel.mongodb.service;

import com.rahul.booking.hotel.mongodb.dao.HotelDao;
import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    public HotelDao hotelDao;

    public List<Hotel> fetchAllHotels() {
        return hotelDao.fetchAllHotels();
    }
}
