package me.shackox.graphql.demographql.service;

import me.shackox.graphql.demographql.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Long countAllProducts();

    Product getProductById(Long id);

    boolean deleteProduct(Long id);

    Product createProduct(String productDescription);

    Product updateProduct(Long id, String productDescription);
}
