package com.akkykaths.user.service.services.implementation;

import com.akkykaths.user.service.entities.Hotel;
import com.akkykaths.user.service.entities.Rating;
import com.akkykaths.user.service.entities.User;
import com.akkykaths.user.service.exceptions.ResourseNotFoundException;
import com.akkykaths.user.service.external.services.HotelService;
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
        List<User> allUsers = this.userRepo.findAll();
        return allUsers;
    }

    // get a single user
    @Override
    public User getUser(String userId) {

        User user =  this.userRepo.findById(userId).orElseThrow(() -> new ResourseNotFoundException("User Not found for userId " + userId));
        // fetching rating of above user from RATING SERVICE
        final String url = "http://RATING-SERVICE/api/ratings/users/" + user.getUserId();

        Rating[] ratingsOfUser = restTemplate.getForObject(url, Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        logger.info("{}",ratingsOfUser);

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            // USING RestTemplate
//            final String hotelUrl = "http://HOTEL-SERVICE/api/hotels/hotel/" + rating.getHotelId();
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(hotelUrl, Hotel.class);

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
