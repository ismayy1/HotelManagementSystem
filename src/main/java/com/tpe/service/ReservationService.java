package com.tpe.service;

import com.tpe.model.Reservation;

import java.util.List;

public interface ReservationService {

    // step 26 c: save Reservation
    Reservation saveReservation();

    // step 27 b: find reservation by id
    void findReservationById (Long id);

    // step 28 c: display all reservations
    List<Reservation> displayAllReservations();

}
