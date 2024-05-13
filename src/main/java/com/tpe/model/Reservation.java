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
            initialValue = 4001,    // starting value of the id
            allocationSize = 1  // optional, by default it'll start with 50
    )
    private Long id;



}
