package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tbl_room")
public class Room {

    @Id
    private Long id;
    @Column (nullable = false)
    private String number;
    @Column (nullable = false)
    private int capacity;

    public Room() {}

    public Room(Long id, String number, int capacity) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
    }


}
