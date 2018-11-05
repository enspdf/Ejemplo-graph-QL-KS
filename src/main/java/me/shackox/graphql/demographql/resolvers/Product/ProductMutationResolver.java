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

    public Product createProduct(String productDescription) {
        return productService.createProduct(productDescription);
    }

    public Product updateProduct(Long id, String productDescription) {
        return productService.updateProduct(id, productDescription);
    }

    public boolean deleteProduct(Long id) {
        return productService.deleteProduct(id);
    }
}
