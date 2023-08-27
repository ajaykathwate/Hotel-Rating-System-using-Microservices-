package com.akkykaths.rating.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * @author Ajay Kathwate - 8/25/2023
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String msg;
    private boolean success;
    private HttpStatus httpStatus;



}
