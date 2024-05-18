package com.tpe.service;

import com.tpe.model.Reservation;
import com.tpe.repository.GuestRepository;
import com.tpe.repository.ReservationRepository;
import com.tpe.repository.RoomRepository;

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
        return null;
    }
}
