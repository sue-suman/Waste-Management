package beans;

import javax.persistence.*;

@Entity
@Table(name = "waste")
public class Waste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private double quantity;

    @ManyToOne
    @JoinColumn(name = "waste_type_id")
    private WasteType wasteType;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public WasteType getWasteType() {
        return wasteType;
    }

    public void setWasteType(WasteType wasteType) {
        this.wasteType = wasteType;
    }

    @Override
    public String toString() {
        return "Waste {" +
                " id =" + id +
                ", name ='" + name + '\'' +
                ", quantity =" + quantity +
                ", wastetype =" + wasteType +
                '}';
    }
}
