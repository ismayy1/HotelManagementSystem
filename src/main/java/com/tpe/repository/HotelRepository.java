package com.tpe.repository;

import com.tpe.model.Hotel;

import java.util.List;

// step 13 a: Create Hotel
public interface HotelRepository {

    Hotel saveHotel (Hotel hotel);

    //step 14:
    // a. find the hotel by id
    Hotel findHotelById (Long id);

    // step 15 a: delete hotel by id
    void deleteHotelById (Long id);

    // step 16 a: findAllHotels
    List<Hotel> displayAllHotels ();

}
