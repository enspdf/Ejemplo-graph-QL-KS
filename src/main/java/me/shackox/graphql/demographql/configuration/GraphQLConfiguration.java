package me.shackox.graphql.demographql.configuration;

import com.coxautodev.graphql.tools.SchemaParser;
import com.zhokhov.graphql.datetime.GraphQLDate;
import com.zhokhov.graphql.datetime.GraphQLLocalDate;
import com.zhokhov.graphql.datetime.GraphQLLocalDateTime;
import com.zhokhov.graphql.datetime.GraphQLLocalTime;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLErrorHandler;
import me.shackox.graphql.demographql.handler.GraphQLErrorAdapter;
import me.shackox.graphql.demographql.resolvers.Prebook.PrebookMutationResolver;
import me.shackox.graphql.demographql.resolvers.Prebook.PrebookQueryResolver;
import me.shackox.graphql.demographql.resolvers.Product.ProductMutationResolver;
import me.shackox.graphql.demographql.resolvers.Product.ProductQueryResolver;
import me.shackox.graphql.demographql.scalars.Scalars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class GraphQLConfiguration {
    @Autowired
    private ProductQueryResolver productQueryResolver;

    @Autowired
    private ProductMutationResolver productMutationResolver;

    @Autowired
    private PrebookQueryResolver prebookQueryResolver;

    @Autowired
    private PrebookMutationResolver prebookMutationResolver;

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);

                return e;
            }

            private boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }

    @Bean
    public GraphQLSchema graphQLSchema() {
        return SchemaParser.newParser()
                .files("graphql/product.graphqls", "graphql/prebook.graphqls", "graphql/prebookItem.graphqls")
                .resolvers(
                        productQueryResolver, productMutationResolver,
                        prebookQueryResolver, prebookMutationResolver
                )
                //.scalars(new GraphQLDate(), new GraphQLLocalDate(), new GraphQLLocalDateTime(), new GraphQLLocalTime())
                .scalars(Scalars.graphQLDate)
                .build()
                .makeExecutableSchema();
    }

    @Bean
    public ProductQueryResolver productQueryResolver() {
        return new ProductQueryResolver();
    }

    @Bean
    public ProductMutationResolver productMutationResolver() {
        return new ProductMutationResolver();
    }

    @Bean
    public PrebookQueryResolver prebookQueryResolver() {
        return new PrebookQueryResolver();
    }

    @Bean
    public PrebookMutationResolver prebookMutationResolver() {
        return new PrebookMutationResolver();
    }
}
