package com.tpe.service;

import com.tpe.exception.HotelNotFoundException;
import com.tpe.model.Hotel;
import com.tpe.repository.HotelRepository;

import java.util.Scanner;

public class HotelServiceImplementation implements HotelService {

    // step 13 b: Override the Save Hotel
    /*
         The HotelServiceImpl constructor is responsible for initializing the hotelRepository field.
         It takes a HotelRepository object as a parameter and assigns it to the hotelRepository field
         using the 'this' keyword
    */

    private final HotelRepository hotelRepository;

//    HotelRepository hotelRepository = new HotelRepositoryImplement();

    private static Scanner scanner;

    public HotelServiceImplementation(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel saveHotel() {

        scanner = new Scanner(System.in);

        Hotel hotel = new Hotel();

        System.out.println("Enter the hotel id:");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter the hotel name:");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter the hotel Location:");
        hotel.setLocation(scanner.nextLine());

        // save the hotel
        hotelRepository.saveHotel(hotel);
        System.out.println("Hotel Saved successfully to the DataBase. Hotel Id: " + hotel.getId());

        return null;
    }

    @Override
    public Hotel findHotelById(Long id) {
//        return hotelRepository.findHotelById(id);   //1004

        try {
            Hotel foundHotel = hotelRepository.findHotelById(id);

            if (foundHotel != null) {
                System.out.println("===========================");
                System.out.println("foundHotel = " + foundHotel);
                return foundHotel;
            } else {
                throw new HotelNotFoundException("Hotel with the id: " + id + " NOT Found!");
            }
        } catch (HotelNotFoundException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return null;
        }

    }

}
