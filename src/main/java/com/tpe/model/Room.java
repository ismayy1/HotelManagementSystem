package com.tpe.model;

import javax.persistence.*;

@Entity
@Table (name = "tbl_room")
public class Room {

    @Id
    private Long id;
    @Column (nullable = false)
    private String number;
    @Column (nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn (name = "hotel_id", nullable = false)
    private Hotel hotel;

    public Room() {}

    public Room(Long id, String number, int capacity) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                ", hotel=" + hotel +
                '}';
    }
}
