package com.akkykaths.rating.service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ajay Kathwate - 8/26/2023
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document("user_ratings")
public class Rating{

    @Id
    private String ratingId;

    private String userId;

    private String hotelId;

    private float rating;

    private String remark;

}