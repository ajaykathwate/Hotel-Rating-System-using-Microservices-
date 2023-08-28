package com.akkykaths.user.service.services.implementation;

import com.akkykaths.user.service.entities.Hotel;
import com.akkykaths.user.service.entities.Rating;
import com.akkykaths.user.service.entities.User;
import com.akkykaths.user.service.exceptions.ResourseNotFoundException;
import com.akkykaths.user.service.external.services.HotelService;
import com.akkykaths.user.service.external.services.RatingService;
import com.akkykaths.user.service.repository.UserRepo;
import com.akkykaths.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Ajay Kathwate - 8/25/2023
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User createUser(User user) {
        // generate unique userid
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        // get all users
        List<User> allUsers = this.userRepo.findAll();

        // get all users with ratings with hotel details
        List<User> users = allUsers.stream().map(user ->{

            // fetching rating of user using Feign Client from RATING-SERVICE
            List<Rating> ratings = ratingService.getRatings(user.getUserId());
            logger.info("{}",ratings);

            // get hotel details of rating from HOTEL-SERVICE using feign client
            List<Rating> ratingList = ratings.stream().map(rating -> {
                // api call to hotel service to get the hotel
                // USING FeignClient
                Hotel hotel = hotelService.getHotel(rating.getHotelId());

                // set the hotel to rating
                rating.setHotel(hotel);

                return rating;
            }).collect(Collectors.toList());

            user.setRatings(ratingList);
            return user;
        }).collect(Collectors.toList());

        return users;
    }

    // get a single user
    @Override
    public User getUser(String userId) {

        User user =  this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User Not found for userId " + userId));

        /*
        // fetching rating of above user from RATING SERVICE using RestTemplate
        final String url = "http://RATING-SERVICE/api/ratings/users/" + user.getUserId();
        Rating[] ratingsOfUser = restTemplate.getForObject(url, Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        logger.info("{}",ratingsOfUser);
         */

        // fetching rating of user using Feign Client from RATING-SERVICE
        List<Rating> ratings = ratingService.getRatings(user.getUserId());
        logger.info("{}",ratings);

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            // USING FeignClient
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            // set the hotel to rating
            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

    @Override
    public User updateUser(String userId, User user) {
        User userGet = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User Not found for userId " + userId));

        userGet.setName(user.getName());
        userGet.setEmail(user.getEmail());
        userGet.setAbout(user.getAbout());
        userGet.setAddress(user.getAddress());
        userGet.setPhone(user.getPhone());

        User savedUser = this.userRepo.save(userGet);

        return savedUser;
    }

    @Override
    public void deleteUser(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User Not found for userId " + userId));
        this.userRepo.delete(user);
    }
}
