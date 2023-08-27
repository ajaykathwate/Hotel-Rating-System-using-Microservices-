package com.akkykaths.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ajay Kathwate - 8/25/2023
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating{

    private String ratingId;

    private String userId;

    private String hotelId;

    private float rating;

    private String remark;

    private Hotel hotel;

}
