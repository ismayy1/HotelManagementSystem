package com.tpe.main;

import com.tpe.exception.HotelNotFoundException;
import com.tpe.model.Hotel;
import com.tpe.repository.*;
import com.tpe.service.*;

import java.util.Scanner;

//step 10: Create HMS Service Class we need to Call this class in Main Class
public class HotelManagementSystemServiceClass {
    //step 10 : Create HMS Service Class we need to Call this clas in Main Class



    private  static Scanner scanner;





    public static void displayMenuHotelManagementSystem(){

        //create an instance of hotel repository and hotel service
        HotelRepository hotelRepository  = new HotelRepositoryImplement();
        HotelService hotelService = new HotelServiceImplementation(hotelRepository);

        //create an instance of Room repository and Room Service

        RoomRepository roomRepository = new RoomRepositoryImplementation();
        RoomService roomService = new RoomServiceImplementation(roomRepository,hotelRepository);

        //create an instance of Guest repository and Guest Service

        GuestRepository guestRepository = new GuestRepositoryImplementation();
        GuestService guestService= new GuestServiceImplementation(guestRepository);


        //create Scanner for the user input

        scanner= new Scanner(System.in);

        //menu Loop

        boolean exit= false;

        while (!exit){
            System.out.println(" ----------  Hotel Management System Menu  ______________");
            System.out.println("1 . Hotel Operation ");
            System.out.println("2 . Room Operation ");
            System.out.println("3 . Guest Operation ");
            System.out.println("4 . Reservation  Operation ");
            System.out.println("5 . Exit ");

            System.out.println("Enter Your Option  : ");

            int choice = scanner.nextInt();
            scanner.nextLine();// it will consume New line

            switch (choice){
                case  1:
                    displayHotelOperationMenu(hotelService);
                    break;

                case  2:
                    displayRoomOperationMenu(roomService);
                    break;

                case  3:
                    displayGuestOperationMenu(guestService);
                    break;

                case  4:
                    System.out.println("4 . Display Reservation  Operation ");
                    break;

                case  5:
                    exit=true;
                    System.out.println("Good Bye !!!!! ");
                    break;
                default:
                    System.out.println("Invalid Choice  Please Try again Later .. ");
                    break;
            }
        }

    }


    //step 13 [a - b - c - d]

    private static void displayHotelOperationMenu(HotelService hotelService){

        scanner= new Scanner(System.in);

        boolean exit = false;

        while (!exit){

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

            switch (choice){

                //step 13 e:
                case  1 :
                    System.out.println("Add new Hotel  : ");
                    hotelService.saveHotel();
                    break;

                //step 14 e : find hotel By id
                case  2 :
                    System.out.println("2. Find Hotel By ID");
                    Long hotelId = scanner.nextLong();
                    hotelService.findHotelById(hotelId);
                    break;


                //step 15 e :delete hotel By Id
                case 3 :
                    System.out.println("Enter  the Hotel Id to Delete : ");
                    Long hotelIdTODelete = scanner.nextLong();
                    hotelService.deleteHotelById(hotelIdTODelete);
                    break;

                //step 16 e : display ALl Hotels
                case  4 :
                    System.out.println("4. Find All Hotels");
                    hotelService.displayAllHotels();
                    break;

                case  5 :

                    //step 17 e update hotel
                    System.out.println("=========== Update Hotel By ID  ==============");
                    System.out.println("Please Enter the Hotel Id to Update : ");

                    Long hotelId1= scanner.nextLong();
                    scanner.nextLine();
                    try {
                        //  Hotel existHotel =  hotelService.findHotelById(hotelId1);
                        System.out.println("Please Enter the Hotel Name : ");
                        String name=  scanner.nextLine();

                        System.out.println("Please Enter the Hotel Location  :");
                        String location= scanner.nextLine();

                        Hotel updateHotel = new Hotel();

                        updateHotel.setId(hotelId1);
                        updateHotel.setName(name);
                        updateHotel.setLocation(location);

                        hotelService.updateHotelById(hotelId1,updateHotel);
                    }catch (HotelNotFoundException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case  6 :
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid Operations  .Please Try again ....");
                    break;
            }

        }

    }


    //step 18 [a - b - c - d] Crud Operation about Room
    private static void displayRoomOperationMenu(RoomService roomService ){

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

                //step 18 e:  save room
                case  1 :
                    System.out.println("========   1. Add new Room  :  ============");
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

    //step 22 [a - b - c - d] Crud Operation about Room
    private static void displayGuestOperationMenu(GuestService guestService){

        scanner= new Scanner(System.in);

        boolean exit = false;

        while (!exit){

            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new Guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice){

                //step 22 e : save the Guest
                case  1 :
                    System.out.println("========   1. Add new Guest  :  ============");
                    guestService.saveGuest();
                    break;

                case 2:
                    System.out.print("Enter the Guest ID to Find: ");
                    Long guestId = scanner.nextLong();
                    guestService.findGuestById(guestId);
                    break;
                case 3:

                    System.out.println("==== Delete Guest By ID ====");
                    System.out.print("Enter the Guest ID to delete: ");
                    break;
                case 4:

                    System.out.println("==== Find All GuestS ====");

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
