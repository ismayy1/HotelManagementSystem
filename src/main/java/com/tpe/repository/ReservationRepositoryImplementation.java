package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.exception.ReservationNotFoundException;
import com.tpe.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

    // step 27 b:
    @Override
    public Reservation findReservationBuId(Long id) {

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Reservation reservation = session.get(Reservation.class, id);
            return reservation;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReservationNotFoundException("Issue Occurred during fetch Reservation");
        }
    }

    // step 28 b: display all reservation
    @Override
    public List<Reservation> findAllReservations() {

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            String hql = "FROM Reservation";
            List<Reservation> reservations = session.createQuery(hql, Reservation.class).getResultList();

            if (reservations.isEmpty()) {
                System.out.println("Reservation List is empty...");
            }

            return reservations;
        } catch (Exception e) {
            throw new ReservationNotFoundException("Failed to Fetch the Reservations");
        }
    }

    @Override
    public void deleteReservationById(Long id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            Reservation reservation = session.load(Reservation.class, id);

            if (reservation != null) {
                session.delete(reservation);
                transaction.commit();
            } else {
                System.out.println("Reservation not found with id: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
