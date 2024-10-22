package beans;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "driver_name")
    private String driverName;
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<WasteCollection> wasteCollections;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public List<WasteCollection> getWasteCollections() {
        return wasteCollections;
    }

    public void setWasteCollections(List<WasteCollection> wasteCollections) {
        this.wasteCollections = wasteCollections;
    }

    @Override
    public String toString() {
        return "Driver {" +
                " id = " + id +
                ", driverName = '" + driverName + '\'' +
                ", wasteCollections = " + wasteCollections +
                '}';
    }
}
