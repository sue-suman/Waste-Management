package beans.DAO;

import beans.Entity.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DriverDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public List<Driver> getAllDrivers() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Driver", Driver.class).list();
        }
    }
}

