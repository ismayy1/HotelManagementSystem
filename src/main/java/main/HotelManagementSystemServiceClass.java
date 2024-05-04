package main;

import java.util.Scanner;

//step 10: Create HMS Service Class we need to Call this class in Main Class
public class HotelManagementSystemServiceClass {

    private static Scanner scanner;

    public static void displayMenuHotelManagementSystem() {

        // create Scanner for the user input
        scanner = new Scanner(System.in);

        //menu loop
        boolean exit = true;

        while (!exit) {
            System.out.println("======= Hotel Management System Menu =======");
            System.out.println("1. Hotel Operation");
            System.out.println("2. Room Operation");
            System.out.println("3. Guest Operation");
            System.out.println("4. Reservation Operation");
            System.out.println("5. Exit Operation");

            System.out.println("Enter you Option:");
        }

    }

}
