package beans.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "waste_type")
public class WasteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "wasteType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Waste> wastes;

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

    public List<Waste> getWastes() {
        return wastes;
    }

    public void setWastes(List<Waste> wastes) {
        this.wastes = wastes;
    }

    @Override
    public String toString() {
        return "WasteType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';  // Exclude 'wastes' from toString to avoid recursion and large outputs
    }
}

