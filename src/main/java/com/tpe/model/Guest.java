package com.tpe.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany (mappedBy = "guest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    public Guest(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
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
    public List<Reservation> getReservations() {
        return reservations;
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", createDate=" + createDate +
//                ", reservations=" + reservations +
                '}';
    }
}
