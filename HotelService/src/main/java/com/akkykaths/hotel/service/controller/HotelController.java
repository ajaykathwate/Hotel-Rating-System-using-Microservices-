package com.akkykaths.hotel.service.controller;

import com.akkykaths.hotel.service.model.Hotel;
import com.akkykaths.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/25/2023
 */

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotelCreated = this.hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotelCreated, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = this.hotelService.getAllHotels();
        return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
        Hotel hotel = this.hotelService.getHotel(hotelId);
        return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
    }



}
