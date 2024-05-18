package com.tpe.repository;

import com.tpe.model.Reservation;

public interface ReservationRepository {

    // step 26 a: save the reservation
    Reservation saveReservation(Reservation reservation);

}
