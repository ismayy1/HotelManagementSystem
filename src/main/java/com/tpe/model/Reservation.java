package com.tpe.model;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column (nullable = false)
    private LocalDate checkIn;

    @Column (nullable = false)
    private LocalDate checkOut;

    @ManyToOne
    @JoinColumn (name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JoinColumn (name = "room_id", nullable = false)
    private Room room;

    // getter setter
    public Reservation() {
    }

    public Reservation(Long id, LocalDate checkIn, LocalDate checkOut, Guest guest, Room room) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guest = guest;
        this.room = room;
    }

    public Long getId() {
        return id;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }
    public LocalDate getCheckOut() {
        return checkOut;
    }
    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
    public Guest getGuest() {
        return guest;
    }
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", guest=" + guest +
                ", room=" + room +
                '}';
    }
}
