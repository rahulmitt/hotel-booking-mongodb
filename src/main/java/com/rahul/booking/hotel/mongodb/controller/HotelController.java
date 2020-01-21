package com.rahul.booking.hotel.mongodb.controller;

import com.rahul.booking.hotel.mongodb.pojo.Hotel;
import com.rahul.booking.hotel.mongodb.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HotelController {
    Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;

    @GetMapping(
            value = "/list",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> checkBalance() {
        logger.info("Listing all hotels");

        try {
            List<Hotel> hotelList = hotelService.fetchAllHotels();
            logger.info("{} hotels retrieved", hotelList.size());
            return ResponseEntity.status(HttpStatus.OK).body(hotelList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
