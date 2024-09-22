package beans.DAO;

import beans.Entity.WasteCollection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class WasteCollectionDAO {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void saveWasteCollection(WasteCollection wasteCollection) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(wasteCollection);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();  // Consider using a logger instead
        }
    }
    public List<WasteCollection> getAllWasteCollections() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from WasteCollection", WasteCollection.class).list();
        }
    }
}
