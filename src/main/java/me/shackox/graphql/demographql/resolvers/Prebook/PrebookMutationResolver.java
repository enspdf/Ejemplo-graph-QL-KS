package me.shackox.graphql.demographql.resolvers.Prebook;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.shackox.graphql.demographql.domain.Prebook;
import org.springframework.stereotype.Component;

@Component
public class PrebookMutationResolver implements GraphQLMutationResolver {
    public Prebook createPrebookHeader (Prebook prebook) {
        return null;
    }

    public Prebook createPrebookWithItems (Prebook prebook) {
        return prebook;
    }

    public Prebook updatePrebookHeader (Long prebookId, Prebook prebook) {
        return prebook;
    }

    public Prebook updatePrebookWithItems (Long prebookId, Prebook prebook) {
        return prebook;
    }

    public boolean deletePrebook (Long prebookId) {
        return false;
    }
}
