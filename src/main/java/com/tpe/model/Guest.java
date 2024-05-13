package com.tpe.model;

import javax.persistence.*;

//step 9: Create guest Entity
@Entity
@Table (name = "tbl_guest")
public class Guest {

    // step 22 fild the guest
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
