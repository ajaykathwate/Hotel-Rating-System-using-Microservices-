package com.akkykaths.hotel.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ajay Kathwate - 8/25/2023
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="hotel")
public class Hotel {

    @Id
    private String hotelId;

    private String name;

    private String location;

    private String about;

}
