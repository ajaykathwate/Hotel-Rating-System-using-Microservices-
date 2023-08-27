package com.akkykaths.hotel.service.reposiroty;

import com.akkykaths.hotel.service.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ajay Kathwate - 8/25/2023
 */
public interface HotelRepo extends MongoRepository<Hotel, String> {
}
