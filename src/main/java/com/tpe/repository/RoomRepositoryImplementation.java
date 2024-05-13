package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.model.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
