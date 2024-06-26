package com.tpe.config;

import com.tpe.model.Hotel;
import com.tpe.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// step 7: HibernateUtils
public class HibernateUtils {

    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//                    .addAnnotatedClass(Hotel.class).addAnnotatedClass(Room.class);    // because we used mapping in hibernate.cfg.xml file, we no longer need to use this .addAnnotatedClass()
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable throwable) {
            System.out.println("Initialize SessionFactory Create Failed!.." + throwable);
            throw  new ExceptionInInitializerError(throwable);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown() {
        getSessionFactory().close();
    }

    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}
