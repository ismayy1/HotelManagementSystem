package com.tpe.service;

import com.tpe.model.Reservation;
import com.tpe.repository.GuestRepository;
import com.tpe.repository.ReservationRepository;
import com.tpe.repository.RoomRepository;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservationServiceImplementation implements ReservationService {

    private Scanner scanner;

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final RoomRepository roomRepository;

    public ReservationServiceImplementation(ReservationRepository reservationRepository,
                                            GuestRepository guestRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
    }

    // step 26 d: save Reservation
    @Override
    public Reservation saveReservation() {

        scanner = new Scanner(System.in);

        System.out.println("Enter Guest by ID: ");
        Long guestId = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the Room ID: ");
        Long roomId = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Enter the check-in date (yyyy-MM-dd): ");
        LocalDate checkInDate = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter the check-out date (yyyy-MM-dd): ");
        LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

        try {

        }

        return null;
    }
}
