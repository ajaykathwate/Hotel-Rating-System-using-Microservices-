package com.akkykaths.user.service.exceptions;

import com.akkykaths.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ajay Kathwate - 8/25/2023
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourseNotFoundException ex) {
        String msg = ex.getMessage();
        ApiResponse response = ApiResponse.builder().msg(msg).success(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }
}
