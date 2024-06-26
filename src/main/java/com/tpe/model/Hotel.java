package com.tpe.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//step 9: Hotel Entity and Room
@Entity
@Table (name = "tbl_hotel")
public class Hotel {

    // step 12: we can add field about Hotel
    @Id
    private Long id;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false, length = 44)
    private String location;

    @OneToMany (mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

    public Hotel() {}

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
