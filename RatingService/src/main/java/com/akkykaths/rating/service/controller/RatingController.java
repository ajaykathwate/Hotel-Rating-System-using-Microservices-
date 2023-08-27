package com.akkykaths.rating.service.controller;

import com.akkykaths.rating.service.entities.Rating;
import com.akkykaths.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/26/2023
 */

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public ResponseEntity<Rating> createRating(@RequestBody Rating ratingRequest){
        Rating rating = this.ratingService.createRating(ratingRequest);
        return new ResponseEntity<Rating>(rating, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> allRatings = this.ratingService.getAllRatings();
        return new ResponseEntity<List<Rating>>(allRatings, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> ratings = this.ratingService.getRatingByUserId(userId);
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratings = this.ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<List<Rating>>(ratings, HttpStatus.OK);
    }

}
