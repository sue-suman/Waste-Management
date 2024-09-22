package beans.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "waste_collection")
public class WasteCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "collection_date")
    private LocalDateTime collectionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "waste_id", nullable = false)
    private Waste waste;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDateTime collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Waste getWaste() {
        return waste;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    @Override
    public String toString() {
        return "WasteCollection{" +
                "id=" + id +
                ", collectionDate=" + collectionDate +
                ", vehicle=" + vehicle.getVehicleNumber() +  // Show vehicle number instead of the entire object
                ", driver=" + driver.getDriverName() +  // Show driver's name instead of the entire object
                ", waste=" + waste.getName() +  // Show waste name instead of the entire object
                '}';
    }
}

