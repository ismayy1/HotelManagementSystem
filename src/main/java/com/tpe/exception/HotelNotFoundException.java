package com.tpe.exception;

//step 8: Custom Exception
public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(String message) {
        super(message);
    }

}
