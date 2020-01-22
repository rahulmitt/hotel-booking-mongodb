package com.rahul.booking.hotel.mongodb.controller;

import com.rahul.booking.hotel.mongodb.dao.HotelDao;
import com.rahul.booking.hotel.mongodb.pojo.Address;
import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import com.rahul.booking.hotel.mongodb.pojo.Rating;
import com.rahul.booking.hotel.mongodb.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private HotelDao hotelDao;

    @Autowired
    public DataLoader(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public void run(String[] args) throws Exception {
        hotelDao.dropHotelsCollection();
        initialize();
    }

    private void initialize() {
        Hotel deltin = new Hotel(
                "Deltin Suites",
                1100d,
                new Address("Goa", "India"),
                Arrays.asList(
                        new Review("Rahul", Rating.EXCEPTIONAL, true),
                        new Review("Neha", Rating.GOOD, false)
                )
        );

        Hotel citrus = new Hotel(
                "Citrus Hotel",
                2100d,
                new Address("Lonavala", "India"),
                Arrays.asList(
                        new Review("Anil", Rating.EXCEPTIONAL, true),
                        new Review("Manjula", Rating.EXCEPTIONAL, true)
                )
        );

        Hotel olhuveli = new Hotel(
                "Olhuveli Resorts",
                1100d,
                new Address("Male", "Maldives"),
                Arrays.asList(
                        new Review("Tushar", Rating.GOOD, false),
                        new Review("Reyansh", Rating.AVERAGE, true)
                )
        );

        List<Hotel> hotels = Arrays.asList(deltin, citrus, olhuveli);
        this.hotelDao.createAllHotels(hotels);
    }
}
