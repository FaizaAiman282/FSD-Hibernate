package col.example.productdemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utility {

    private static SessionFactory sessionFactory;

    static {
        try {
            System.out.println("Loading Hibernate...");

            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();

            System.out.println("SessionFactory created!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}