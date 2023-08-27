package com.akkykaths.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ajay Kathwate - 8/27/2023
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private String hotelId;

    private String name;

    private String location;

    private String about;

}
