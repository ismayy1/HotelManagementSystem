package com.tpe.model;

import javax.persistence.*;
import java.time.LocalDateTime;

//step 9: Create guest Entity
@Entity
@Table (name = "tbl_guest")
public class Guest {

    // step 22 fild the guest
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Embedded   // optional
    private Address address;

    private LocalDateTime createDate;

    @PrePersist // when we want to save the object to DB, this must be called
    public void PrePersist () {
        createDate = LocalDateTime.now();
    }

}
