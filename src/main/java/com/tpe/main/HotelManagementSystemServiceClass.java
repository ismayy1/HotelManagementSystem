package com.tpe.main;

import com.tpe.exception.HotelNotFoundException;
import com.tpe.model.Hotel;
import com.tpe.repository.HotelRepository;
import com.tpe.repository.HotelRepositoryImplement;
import com.tpe.repository.RoomRepository;
import com.tpe.repository.RoomRepositoryImplementation;
import com.tpe.service.HotelService;
import com.tpe.service.HotelServiceImplementation;
import com.tpe.service.RoomService;
import com.tpe.service.RoomServiceImplementation;

import java.util.Scanner;

//step 10: Create HMS Service Class we need to Call this class in Main Class
public class HotelManagementSystemServiceClass {

    private static Scanner scanner;

    //create an instance of hotelRepository and hotelService
    public static void displayMenuHotelManagementSystem() {

        HotelRepository hotelRepository = new HotelRepositoryImplement();
        HotelService hotelService = new HotelServiceImplementation(hotelRepository);


        // create an instance of room repository and room service
        RoomRepository roomRepository = new RoomRepositoryImplementation();
        RoomService roomService = new RoomServiceImplementation(roomRepository, hotelRepository);

        // create Scanner for the user input
        scanner = new Scanner(System.in);

        //menu loop
        boolean exit = false;

        while (!exit) {
            System.out.println("======= Hotel Management System Menu =======");
            System.out.println("1. Hotel Operation");
            System.out.println("2. Room Operation");
            System.out.println("3. Guest Operation");
            System.out.println("4. Reservation Operation");
            System.out.println("5. Exit Operation");

            System.out.println("Enter you Selection Number:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // it'll consume NewLine

            switch (choice) {
                case 1:
                    System.out.println("1. Display Hotel Operation");
                    displayHotelOperationMenu(hotelService);
                    break;
                case 2:
                    System.out.println("2. Display Room Operation");
                    displayHotelOperationMenu(hotelService);
                    break;
                case 3:
                    System.out.println("3. Display Guest Operation");
                    break;
                case 4:
                    System.out.println("4. Display Reservation Operation");
                    break;
                case 5:
                    exit = true;
                    System.out.println("Good Bye!!!");
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again Later!");
                    break;
            }
        }

    }

    // step 13 [a-b-c-d]
    private static void displayHotelOperationMenu(HotelService hotelService) {

        scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // step 13 e:
                case 1:
                    System.out.println("============== Add new Hotel ==============");
                    hotelService.saveHotel();
                    break;
                case 2:
                    System.out.println("============== Find Hotel By ID ==============");

                    // step 14 e:
                    Long hotelId = scanner.nextLong();
                    hotelService.findHotelById(hotelId);
                    break;
                case 3:
                    System.out.println("============== Enter the id of a hotel to delete ==============");
                    // step 15 e: delete hotel by id
                    Long hotelIdToDelete = scanner.nextLong();
                    hotelService.deleteHotelById(hotelIdToDelete);
                    break;
                case 4:
                    // display all hotels
                    System.out.println("============== Find All Hotels ==============");
                    hotelService.displayAllHotels();
                    break;
                case 5:
                    // step 17e. update hotel by id
                    System.out.println("============== Update Hotel By ID ==============");
                    System.out.println("Please enter the hotel id: ");
                    Long hotelId1 = scanner.nextLong();
                    scanner.nextLine();

                    try {
//                        Hotel hotelExists = hotelService.findHotelById(hotelId1);
                        System.out.println("Please enter the Hotel Name: ");
                        String hotelName = scanner.nextLine();

                        System.out.println("Please enter the Hotel Location: ");
                        String hotelLocation = scanner.nextLine();

                        Hotel updateHotel = new Hotel();
                        updateHotel.setId(hotelId1);
                        updateHotel.setName(hotelName);
                        updateHotel.setLocation(hotelLocation);

                        hotelService.updateHotelById(hotelId1, updateHotel);

                    } catch (HotelNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("============== Invalid Operation. Please try again ==============");
                    break;
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    //step 18 [a - b - c - d] Crud Operation about Room
    private static void displayRoomOperationMenu(RoomService roomService){

        scanner= new Scanner(System.in);

        boolean exit = false;

        while (!exit){

            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new Room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice){

                // step 18 e: save Room
                case  1 :
                    System.out.println("1. Add new Room  : ");
                    roomService.saveRoom();
                    break;
                case 2:
                    //step 19e : findRoomById
                    System.out.print("Enter the Room ID to Find: ");
                    Long roomId = scanner.nextLong();
                    roomService.findRoomById(roomId);
                    break;
                case 3:
                    //step 20e: findAllRoom
                    System.out.println("==== Delete Room By ID ====");
                    System.out.print("Enter the room ID to delete: ");
                    Long roomIdToDelete = scanner.nextLong();
                    scanner.nextLine(); // Consume the newline character
                    roomService.deleteRoomById(roomIdToDelete);
                    break;
                case 4:
                    //step 21e:deleteRoomById
                    System.out.println("==== Find All Rooms ====");
                    roomService.findAllRooms();
                    break;
                case  5 :
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid Operations  .Please Try again ....");
                    break;
            }
        }
    }
}
