package me.shackox.graphql.demographql.resolver.product;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.shackox.graphql.demographql.domain.Product;
import me.shackox.graphql.demographql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private ProductService productService;

    public boolean deleteProduct (Long id) {
        return productService.deleteProduct(id);
    }

    public Product createProduct (Product product) {
        return productService.createProduct(product);
    }

    public Product updateProduct (Long id, Product product) {
        return productService.updateProduct(id, product);
    }
}
