import beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Open session
        Session session = factory.openSession();

        // Transaction management
        Transaction transaction = session.beginTransaction();
        try {
            // Create Driver
            Driver driver = new Driver();
            driver.setDriverName("Panni");

            // Create Vehicle
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber("AB1234CD");

            // Create WasteType
            WasteType wasteType = new WasteType();
            wasteType.setTypeName("Plastic");

            // Create Waste
            Waste waste = new Waste();
            waste.setName("Plastic Bottles");
            waste.setQuantity(50.0);
            waste.setWasteType(wasteType);

            // Create WasteCollection
            WasteCollection wasteCollection = new WasteCollection();
            wasteCollection.setCollectionDate(LocalDateTime.now());
            wasteCollection.setDriver(driver);
            wasteCollection.setVehicle(vehicle);
            wasteCollection.setWaste(waste);

            // Save all entities to the database
            session.save(wasteType);
            session.save(driver);
            session.save(vehicle);
            session.save(waste);
            session.save(wasteCollection);

            // Commit the transaction
            transaction.commit();

            // Display data from each entity using toString()
            System.out.println(driver.toString());
            System.out.println(vehicle.toString());
            System.out.println(wasteType.toString());
            System.out.println(waste.toString());
            System.out.println(wasteCollection.toString());

            session.getTransaction().commit(); // Commit transaction
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
