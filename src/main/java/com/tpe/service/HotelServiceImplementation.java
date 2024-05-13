package com.tpe.service;

import com.tpe.exception.HotelNotFoundException;
import com.tpe.model.Hotel;
import com.tpe.repository.HotelRepository;

import java.util.List;
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

    // step 14 c: delete hotel by id
    @Override
    public void deleteHotelById(Long id) {
//        hotelRepository.deleteHotelById(id);

        scanner = new Scanner(System.in);

        try {
            Hotel hotelToDelete = hotelRepository.findHotelById(id);

            if (hotelToDelete == null) {
                throw new HotelNotFoundException("Hotel Not Found with id: " + id);
            }

            System.out.println("hotelToDelete = " + hotelToDelete);
            System.out.println("Are you sure you want to delete the hotel with id: " + hotelToDelete.getId() + "? (Y/N");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("y")) {
                hotelRepository.deleteHotelById(hotelToDelete.getId());
                System.out.println("The hotel with the id: " + hotelToDelete.getId() + " deleted successfully");
            } else {
                System.out.println("Delete Operation Cancelled..");
            }
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Hotel> displayAllHotels() {

//        hotelRepository.displayAllHotels();

        try {
            List<Hotel> hotels = hotelRepository.displayAllHotels();

            if (!hotels.isEmpty()) {
                System.out.println("List of Hotels: ");
                for (Hotel hotel: hotels) {
                    System.out.println("hotel = " + hotel);
                    System.out.println("===============================");
                }
            }else {
                System.out.println("Hotel list is empty...");
            }
        } catch (Exception e) {
            System.out.println("An error occurred While retrieving the hotels: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateHotelById(Long id, Hotel updateHotel) throws HotelNotFoundException {

        try {
            Hotel existingHotel = hotelRepository.findHotelById(id);

            if (existingHotel == null) {
                throw new HotelNotFoundException("Hotel Not Found with id: " + id);
            }
            // perform a validation or business logic before updating
            existingHotel.setName(updateHotel.getName());
            existingHotel.setLocation(updateHotel.getLocation());

            hotelRepository.updateHotel(existingHotel);
            System.out.println("Hotel Updated Successfully");
        } catch (HotelNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
