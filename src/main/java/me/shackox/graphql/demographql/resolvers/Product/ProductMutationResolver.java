package me.shackox.graphql.demographql.resolvers.Product;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.shackox.graphql.demographql.domain.Product;
import me.shackox.graphql.demographql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private ProductService productService;

    public Product createProduct(Product product) {
        return productService.createProduct(product);
    }

    public Product updateProduct(Long id, Product product) {
        return productService.updateProduct(id, product);
    }

    public boolean deleteProduct(Long id) {
        return productService.deleteProduct(id);
    }
}
