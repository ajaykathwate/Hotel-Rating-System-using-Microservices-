package com.akkykaths.user.service.external.services;

import com.akkykaths.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/28/2023
 */

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/api/ratings/users/{userId}")
    List<Rating> getRatings(@PathVariable("userId") String userId);

}
