package com.tpe.repository;

import com.tpe.config.HibernateUtils;
import com.tpe.model.Address;
import com.tpe.model.Guest;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
