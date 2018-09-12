package me.shackox.graphql.demographql.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblProduct")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "boxes")
    private Integer boxes;

    @Column(name = "bunches")
    private Integer bunches;

    @Column(name = "stemsBunch")
    private Integer stemsBunch;

    @Column(name = "unitCost")
    private Double unitCost;

    public Product() {
    }

    public Product(String description, Integer boxes, Integer bunches, Integer stemsBunch, Double unitCost) {
        this.description = description;
        this.boxes = boxes;
        this.bunches = bunches;
        this.stemsBunch = stemsBunch;
        this.unitCost = unitCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBoxes() {
        return boxes;
    }

    public void setBoxes(Integer boxes) {
        this.boxes = boxes;
    }

    public Integer getBunches() {
        return bunches;
    }

    public void setBunches(Integer bunches) {
        this.bunches = bunches;
    }

    public Integer getStemsBunch() {
        return stemsBunch;
    }

    public void setStemsBunch(Integer stemsBunch) {
        this.stemsBunch = stemsBunch;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }
}
