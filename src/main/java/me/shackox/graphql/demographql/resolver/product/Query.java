package me.shackox.graphql.demographql.resolver.product;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.shackox.graphql.demographql.domain.Product;
import me.shackox.graphql.demographql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    @Autowired
    private ProductService productService;

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public Long countAllProducts () {
        return productService.countAllProducts();
    }

    public Product getProductById(Long id) {
        return productService.getProductById(id);
    }
}
