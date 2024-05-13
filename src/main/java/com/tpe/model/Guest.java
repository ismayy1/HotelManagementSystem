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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", address=" + address +
                ", createDate=" + createDate +
                '}';
    }
}
