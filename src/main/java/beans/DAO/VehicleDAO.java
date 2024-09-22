package beans.DAO;

import beans.Entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class VehicleDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public List<Vehicle> getAllVehicles() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Vehicle", Vehicle.class).list();
        }
    }
}
