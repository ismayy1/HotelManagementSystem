package com.tpe.service;

import com.tpe.model.Room;

import java.util.List;

public interface RoomService {

    // step 18 c: save Room
    Room saveRoom();

    //step 19c :findRoomById
    Room findRoomById(Long id);

    //step 20c: findAllRoom
    List<Room> findAllRooms();

    //step 21c:deleteRoomById
    void deleteRoomById(Long id);

}
