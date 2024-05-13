package com.tpe.model;

import javax.persistence.*;

// step 9 d: create reservation
@Entity
@Table (name = "tbl_reservation")
public class Reservation {

    // step 26: Reservation file here

    @Id
    @GeneratedValue (generator = "sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "sequence",
            sequenceName = "reservation_id",
            initialValue = 4001
    )
    private Long id;



}
