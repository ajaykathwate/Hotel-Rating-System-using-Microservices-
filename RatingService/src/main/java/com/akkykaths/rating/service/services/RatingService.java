package com.akkykaths.rating.service.services;

import com.akkykaths.rating.service.entities.Rating;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/26/2023
 */
public interface RatingService {

    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

}
