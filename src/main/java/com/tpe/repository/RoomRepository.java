package com.tpe.repository;

import com.tpe.model.Room;

import java.util.List;

public interface RoomRepository {

    // step 18 a: save Room
    Room saveRoom(Room room);

    //step 19a : findRoomById
    Room findRoomById(Long roomId);

    //step 20a: findAllRoom
    List<Room> findAllRoom();

    //step 21a:deleteRoomById
    void deleteRoomById(Long id);

}
