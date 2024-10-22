package beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "waste_type")
public class WasteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "wasteType")
    private Set<Waste> wastes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<Waste> getWastes() {
        return wastes;
    }

    public void setWastes(Set<Waste> wastes) {
        this.wastes = wastes;
    }

    @Override
    public String toString() {
        return "WasteType {" +
                " id = " + id +
                ", typeName = '" + typeName + '\'' +
                ", wastes = " + wastes +
                '}';
    }
}
