package com.tpe.service;

import com.tpe.exception.HotelNotFoundException;
import com.tpe.model.Hotel;
import com.tpe.model.Room;
import com.tpe.repository.HotelRepository;
import com.tpe.repository.RoomRepository;

import java.util.Scanner;

public class RoomServiceImplementation implements RoomService {

    private static Scanner scanner;

    private final RoomRepository roomRepository;

    private final HotelRepository hotelRepository;

    public RoomServiceImplementation(RoomRepository roomRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.hotelRepository = hotelRepository;
    }

    // step 18 d: saveRoom
    @Override
    public Room saveRoom() {

        scanner = new Scanner(System.in);

        System.out.println("Please enter the room id: ");
        Room room = new Room();
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter the room number: ");
        room.setNumber(scanner.nextLine());

        System.out.println("Enter the room capacity: ");
        room.setCapacity(scanner.nextInt());

        // promt the user to enter the hotel id
        System.out.println("Enter the id of the Hotel: ");
        Long hotelId = scanner.nextLong();
        scanner.nextLine();

        try {
            // find the hotel
            Hotel exsistingHotel = hotelRepository.findHotelById(hotelId);

            if (exsistingHotel == null) {
                throw new HotelNotFoundException("Hotel Not Found with an id: " + hotelId);
            }

            // Associated the room with hotel
            room.setHotel(exsistingHotel);

            // save the room using room repository
            Room savedRoom = roomRepository.saveRoom(room);

            // add room to the hotel's room collections
            exsistingHotel.getRooms().add(savedRoom);
            System.out.println("Room Saved Successfully...");

        } catch (HotelNotFoundException e) {
            e.printStackTrace();
        }

        return room;
    }
}
