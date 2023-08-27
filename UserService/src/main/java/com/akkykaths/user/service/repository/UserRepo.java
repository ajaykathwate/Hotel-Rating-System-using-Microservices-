package com.akkykaths.user.service.repository;

import com.akkykaths.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ajay Kathwate - 8/25/2023
 */
public interface UserRepo extends JpaRepository<User, String> {



}
