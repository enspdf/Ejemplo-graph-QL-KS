package me.shackox.graphql.demographql.domain;

public class Product {
    private Long id;
    private String description;
    private Integer boxes;
    private Integer bunches;
    private Integer stemsBunch;
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
