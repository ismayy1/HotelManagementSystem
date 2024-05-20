package com.tpe.repository;

import com.tpe.model.Reservation;

public interface ReservationRepository {

    // step 26 a: save the reservation
    Reservation saveReservation(Reservation reservation);

    // step 27 a: find reservation by ID
    Reservation findReservationBuId(Long id);

}
