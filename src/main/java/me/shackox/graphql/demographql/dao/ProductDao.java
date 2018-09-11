package me.shackox.graphql.demographql.dao;

import me.shackox.graphql.demographql.domain.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getAllProducts();

    Long countAllProducts();

    Product getProductById(Long id);

    boolean deleteProduct(Long id);
}
