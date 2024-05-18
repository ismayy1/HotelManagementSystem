package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.exception.GuestNotFoundException;
import com.tpe.model.Address;
import com.tpe.model.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GuestRepositoryImplementation implements GuestRepository {

    //step 22 b: save guest
    @Override
    public void saveGuest(Guest guest) {

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            // create a new object from Address
            Address address = new Address();

            address.setCity(guest.getAddress().getAddress());   // this is for the street name ***
            address.setCity(guest.getAddress().getCity());
            address.setCountry(guest.getAddress().getCountry());
            address.setZipCode(guest.getAddress().getZipCode());

            guest.setAddress(address);

            session.save(guest);

            transaction.commit();
            session.close();
            HibernateUtils.getSessionFactory().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //23b : findGuestById
//    @Override
//    public Guest findGuestById(Long guestId) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        return session.get(Guest.class, guestId);
//    }


    // Criteria API findGuestByID:
    @Override
    public Guest findGuestById(Long guestId) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Guest> query = builder.createQuery(Guest.class);
            Root<Guest> root = query.from(Guest.class);

            query.select(root).where(builder.equal(root.get("id"), guestId));

            return session.createQuery(query).uniqueResult();
        } catch (GuestNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }


    //24b: deleteGuestById
    @Override
    public void deleteGuestById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Guest guest = session.get(Guest.class, id);
            if (guest != null) {
                // Remove the guest from any associated reservations
                guest.getReservations().forEach(reservation -> reservation.setGuest(null));

                // Delete the guest
                session.delete(guest);
            }



            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //25a: findALlGuest
    @Override
    public List<Guest> findAllGuest() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        String hql = "FROM Guest";
        List<Guest> guests = session.createQuery(hql, Guest.class).getResultList();
        return guests;
    }
}
