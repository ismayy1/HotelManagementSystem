package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.model.Hotel;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HotelRepositoryImplement implements HotelRepository {

    // step 13 b: override method
    @Override
    public Hotel saveHotel(Hotel hotel) {

        try {   // try-catch will automatically close your transaction
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.save(hotel);

            transaction.commit();
//            HibernateUtils.closeSession(session);
            session.close();

            return hotel;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    // step 14: b. find Hotel by id
    @Override
    public Hotel findHotelById(Long id) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Hotel.class, id);
    }

}
