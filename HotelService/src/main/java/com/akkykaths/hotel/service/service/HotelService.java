package com.akkykaths.hotel.service.service;

import com.akkykaths.hotel.service.model.Hotel;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/25/2023
 */
public interface HotelService {

    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);

}
