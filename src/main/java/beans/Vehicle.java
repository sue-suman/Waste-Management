package beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<WasteCollection> wasteCollections;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public List<WasteCollection> getWasteCollections() {
        return wasteCollections;
    }

    public void setWasteCollections(List<WasteCollection> wasteCollections) {
        this.wasteCollections = wasteCollections;
    }

    @Override
    public String toString() {
        return "Vehicle {" +
                " id = " + id +
                ", vehicleNumber = '" + vehicleNumber + '\'' +
                ", wasteCollections = " + wasteCollections +
                '}';
    }
}
