package me.shackox.graphql.demographql.handler;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultGraphQLErrorHandler implements GraphQLErrorHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultGraphQLErrorHandler.class);

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        final List<GraphQLError> clientErrors = filterGraphQLErrors(errors);
        if (clientErrors.size() < errors.size()) {

            // Some errors were filtered out to hide implementation - put a generic error in place.
            clientErrors.add(new GenericGraphQLError("Internal Server Error(s) while executing query"));

            errors.stream()
                    .filter(error -> !isClientError(error))
                    .forEach(error -> {
                        if (error instanceof Throwable) {
                            LOGGER.error("Error executing query!", (Throwable) error);
                        } else {
                            LOGGER.error("Error executing query ({}): {}", error.getClass().getSimpleName(), error.getMessage());
                        }
                    });
        }

        return clientErrors;
    }

    private List<GraphQLError> filterGraphQLErrors(List<GraphQLError> errors) {
        return errors.stream()
                .filter(this::isClientError)
                .collect(Collectors.toList());
    }

    private boolean isClientError(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            return ((ExceptionWhileDataFetching) error).getException() instanceof GraphQLError;
        }
        return !(error instanceof Throwable);
    }
}
