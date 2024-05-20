package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReservationRepositoryImplementation implements ReservationRepository {

    // step 26 b: save reservation
    @Override
    public Reservation saveReservation(Reservation reservation) {

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.save(reservation);
            transaction.commit();

            return reservation;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Reservation findReservationBuId(Long id) {

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Reservation reservation = session.get(Reservation.class, id);
            return reservation;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
