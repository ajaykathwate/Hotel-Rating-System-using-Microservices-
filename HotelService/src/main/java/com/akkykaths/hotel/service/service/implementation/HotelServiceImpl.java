package com.akkykaths.hotel.service.service.implementation;

import com.akkykaths.hotel.service.exceptions.ResourseNotFoundException;
import com.akkykaths.hotel.service.model.Hotel;
import com.akkykaths.hotel.service.reposiroty.HotelRepo;
import com.akkykaths.hotel.service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/25/2023
 */

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return this.hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(()-> new ResourseNotFoundException("Hotel not found for hotelId " + hotelId));
        return hotel;
    }
}
