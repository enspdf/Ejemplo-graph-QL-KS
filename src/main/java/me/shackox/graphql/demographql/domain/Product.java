package me.shackox.graphql.demographql.domain;

public class Product {
    private Long id;
    private String description;

    public Product() {
    }

    public Product(String description) {
        this.description = description;
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
}
