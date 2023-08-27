package com.akkykaths.user.service.external.services;

import com.akkykaths.user.service.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Ajay Kathwate - 8/27/2023
 */

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/api/hotels/hotel/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);

}
