package me.shackox.graphql.demographql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.shackox.graphql.demographql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private ProductService productService;

    public boolean deleteProduct (Long id) {
        return productService.deleteProduct(id);
    }
}
