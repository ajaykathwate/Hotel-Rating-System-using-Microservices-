package com.akkykaths.user.service.controller;

import com.akkykaths.user.service.entities.User;
import com.akkykaths.user.service.payload.ApiResponse;
import com.akkykaths.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/25/2023
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user = this.userService.getUser(userId);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user){
        User updatedUser = this.userService.updateUser(userId, user);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true, HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = this.userService.getAllUsers();
        return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
    }

}
