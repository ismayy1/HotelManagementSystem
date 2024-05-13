package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.model.Hotel;
import com.tpe.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepositoryImplementation implements RoomRepository {

    // step 18 b: save Room
    @Override
    public Room saveRoom(Room room) {

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.save(room);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return room;
    }



    //step 19b : findRoomById
    @Override
    public Room findRoomById(Long roomId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Room.class, roomId);
    }

    //step 20b: findAllRoom
    @Override
    public List<Room> findAllRoom() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            String hql = "FROM Room";
            List<Room> rooms = session.createQuery(hql, Room.class).getResultList();
            // System.out.println(rooms);
            return rooms;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //step 21b:deleteRoomById
    @Override
    public void deleteRoomById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Room room = session.get(Room.class, id);
            if (room != null) {
                // Remove the room from the associated hotel's room list
                Hotel hotel = room.getHotel();
                if (hotel != null) {
                    hotel.getRooms().remove(room);
                }
                // Delete the room
                session.delete(room);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
