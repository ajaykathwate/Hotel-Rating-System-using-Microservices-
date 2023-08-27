package com.akkykaths.rating.service.repository;

import com.akkykaths.rating.service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/26/2023
 */
public interface RatingRepo extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);

}
