package com.tpe.main;

import com.tpe.repository.HotelRepository;
import com.tpe.repository.HotelRepositoryImplement;
import com.tpe.service.HotelService;
import com.tpe.service.HotelServiceImplementation;

import java.util.Scanner;

//step 10: Create HMS Service Class we need to Call this class in Main Class
public class HotelManagementSystemServiceClass {

    private static Scanner scanner;

    //create an instance of hotelRepository and hotelService
    public static void displayMenuHotelManagementSystem() {

        HotelRepository hotelRepository = new HotelRepositoryImplement();
        HotelService hotelService = new HotelServiceImplementation(hotelRepository);

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
                case 1:
                    System.out.println("Add new Hotel: ");
                    hotelService.saveHotel();
                    break;
                case 2:
                    System.out.println("2. Find Hotel By ID");
                    break;
                case 3:
                    System.out.println("3. Delete Hotel By ID");
                    break;
                case 4:
                    System.out.println("4. Find All Hotels");
                    break;
                case 5:
                    System.out.println("5. Update Hotel By ID");
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Operation. Please try again!");
                    break;
            }
        }
    }
}
