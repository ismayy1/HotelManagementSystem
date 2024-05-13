package com.tpe.service;

import com.tpe.exception.HotelNotFoundException;
import com.tpe.model.Hotel;

import java.util.List;

public interface HotelService {

    // step 13 c: save Hotel
    Hotel saveHotel();

    // step 14 c: find hotel by id
    Hotel findHotelById (Long id);

    // step 15 c: delete hotel by id
    void deleteHotelById(Long id);

    //display all Hotels
    List<Hotel> displayAllHotels();

    // update hotel by id
    void updateHotelById(Long id, Hotel updateHotel) throws HotelNotFoundException;

}
