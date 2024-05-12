package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.exception.HotelNotFoundException;
import com.tpe.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    // step 15 b: delete hotel by id
    @Override
    public void deleteHotelById(Long id) {

        try {

            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Hotel hotelIdToDelete = session.get(Hotel.class, id);

            if (hotelIdToDelete != null) {
                session.delete(hotelIdToDelete);;
                transaction.commit();
            } else {
                throw new HotelNotFoundException("Hotel not Found Exception with id: " + id);
            }

            session.close();
//        HibernateUtils.closeSession(session); // either one is okay to close the session
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    // step 16 B: display all hotels
    @Override
    public List<Hotel> findAllHotels() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("FROM Hotel", Hotel.class).getResultList();
    }

}
