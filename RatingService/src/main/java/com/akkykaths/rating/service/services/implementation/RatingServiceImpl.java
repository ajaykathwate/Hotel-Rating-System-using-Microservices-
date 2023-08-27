package com.akkykaths.rating.service.services.implementation;

import com.akkykaths.rating.service.entities.Rating;
import com.akkykaths.rating.service.repository.RatingRepo;
import com.akkykaths.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/26/2023
 */

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
        return this.ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return this.ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return this.ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return this.ratingRepo.findByHotelId(hotelId);
    }
}
