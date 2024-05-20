package com.tpe.repository;

import com.tpe.model.Reservation;

import java.util.List;

public interface ReservationRepository {

    // step 26 a: save the reservation
    Reservation saveReservation(Reservation reservation);

    // step 27 a: find reservation by ID
    Reservation findReservationBuId(Long id);

    // step 28: display all reservations
    List<Reservation> findAllReservations();

    Reservation deleteReservationById (Long id);

}
