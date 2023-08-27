package com.akkykaths.user.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ajay Kathwate - 8/25/2023
 */

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String userId;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
