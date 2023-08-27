package com.akkykaths.user.service.services;

import com.akkykaths.user.service.entities.User;

import java.util.List;

/**
 * @author Ajay Kathwate - 8/25/2023
 */
public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    User updateUser(String userId, User user);

    void deleteUser(String userId);

}
