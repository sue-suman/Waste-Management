package beans.DAO;


import beans.Entity.Waste;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class WasteDAO {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void saveWaste(Waste waste) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(waste);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

    }

    public List<Waste> getAllWastes() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from Waste", Waste.class).list();
        }
    }
}
