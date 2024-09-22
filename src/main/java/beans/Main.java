package beans;

import beans.DAO.DriverDAO;
import beans.DAO.VehicleDAO;
import beans.DAO.WasteCollectionDAO;
import beans.DAO.WasteDAO;
import beans.Entity.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WasteDAO wdao = new WasteDAO();
        WasteCollectionDAO wcdao = new WasteCollectionDAO();
        VehicleDAO vdao = new VehicleDAO();
        DriverDAO ddao = new DriverDAO();

        // 1.1 Create WasteType named Organic.
        WasteType organicWasteType = new WasteType();
        organicWasteType.setTypeName("Organic");


        // 1.2 Create WasteType named Recyclable.
        WasteType recyclableWasteType = new WasteType();
        recyclableWasteType.setTypeName("Recyclable");

        // 2. Create Waste object and set all the values to it.
        // INPUT 1
        Waste waste1 = new Waste();
        waste1.setName("Food Waste");
        waste1.setQuantity(150.0);
        waste1.setWasteType(organicWasteType);

        // INPUT 2
        Waste waste2 = new Waste();
        waste2.setName("Plastic Waste");
        waste2.setQuantity(75.0);
        waste2.setWasteType(recyclableWasteType);

        // 3. Create Vehicle which will be involved in transporting waste.
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleNumber("MH12 AB 1234");

        // 4. Create Driver object.
        Driver driver1 = new Driver();
        driver1.setDriverName(" Finny ");

        // 5. Creating Waste Collection Event.
        WasteCollection wc1 = new WasteCollection();
        wc1.setCollectionDate(LocalDateTime.now());
        wc1.setVehicle(vehicle1);
        wc1.setDriver(driver1);
        wc1.setWaste(waste1);

        // 6. Creating second Waste Collection Event.
        WasteCollection wc2 = new WasteCollection();
        wc2.setCollectionDate(LocalDateTime.now().plusDays(1));
        wc2.setVehicle(vehicle1);
        wc2.setDriver(driver1);
        wc2.setWaste(waste2);

        // Now Saving Waste entities.
        wdao.saveWaste(waste1);
        wdao.saveWaste(waste2);

        // WasteCollection entities.
        wcdao.saveWasteCollection(wc1);
        wcdao.saveWasteCollection(wc2);

        System.out.println("Data saved successfully!");


        // DISPLAYING ALL THE INPUTS.

        // Fetch and display all Waste entities and display it using toSting().
        List<Waste> wastes = wdao.getAllWastes();
        System.out.println("Wastes:");
        for (Waste waste : wastes) {
            System.out.println(waste);
        }

        // Fetch and display all WasteCollection entities and display it using toSting().
        List<WasteCollection> wasteCollections = wcdao.getAllWasteCollections();
        System.out.println("\nWaste Collections:");
        for (WasteCollection wc : wasteCollections) {
            System.out.println(wc);
        }

        // Fetch and display all Vehicles using toSting().
        List<Vehicle> vehicles = vdao.getAllVehicles();
        System.out.println("\nVehicles:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        // Fetch and display all Drivers using toSting().
        List<Driver> drivers = ddao.getAllDrivers();
        System.out.println("\nDrivers:");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}

