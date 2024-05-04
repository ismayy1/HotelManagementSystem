package main;

import java.util.Scanner;

//step 10: Create HMS Service Class we need to Call this class in Main Class
public class HotelManagementSystemServiceClass {

    private static Scanner scanner;

    public static void displayMenuHotelManagementSystem() {

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

            System.out.println("Enter you Selection Option Number:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // it'll consume NewLine

            switch (choice) {
                case 1:
                    System.out.println("1. Display Hotel Operation");
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
                    System.out.println("5. Display Exit Operation");
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again Later!");
                    break;
            }
        }

    }

}
