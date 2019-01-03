package edu.uh.tech.cis3368.manufacture;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Part {
    private int partId;
    private String partName;
    private Integer partPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Basic
    @Column(name = "part_name")
    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Basic
    @Column(name = "part_price")
    public Integer getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(Integer partPrice) {
        this.partPrice = partPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return partId == part.partId &&
                Objects.equals(partName, part.partName) &&
                Objects.equals(partPrice, part.partPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partId, partName, partPrice);
    }
}
