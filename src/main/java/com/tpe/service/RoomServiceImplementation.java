package com.tpe.service;

import com.tpe.exception.HotelNotFoundException;
import com.tpe.exception.RoomNotFoundException;
import com.tpe.model.Hotel;
import com.tpe.model.Room;
import com.tpe.repository.HotelRepository;
import com.tpe.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;
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



    // Step 19d :findRoomById
    @Override
    public Room findRoomById(Long id) {
        try {
            Room foundRoom = roomRepository.findRoomById(id);
            if (foundRoom != null) {
                System.out.println("---------------------------------");
                System.out.println(foundRoom);

                return foundRoom;
            } else {
                throw new RoomNotFoundException(" Room  not found with ID: " + id);
            }
        }catch (RoomNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //step 20c :findAllRooms

    @Override
    public List<Room> findAllRooms() {
        try {
            List<Room> rooms = roomRepository.findAllRoom();
            if (!rooms.isEmpty()) {
                for (Room room : rooms) {
                    System.out.println(room);
                }
            } else {
                throw new RuntimeException("No rooms found.");
            }
            return rooms;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>(); // Return an empty ArrayList
        }
    }


    //step 21d : deleteRoomById
    @Override
    public void deleteRoomById(Long id) {
        try {
            Room existingRoom = roomRepository.findRoomById(id);
            if (existingRoom == null) {
                throw new RoomNotFoundException("Room not found with ID: " + id);
            }

            roomRepository.deleteRoomById(id);
            System.out.println("Room  deleted successfully. ID: " + id);
        } catch (RoomNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
