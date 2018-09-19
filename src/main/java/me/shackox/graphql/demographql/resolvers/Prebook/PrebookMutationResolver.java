package me.shackox.graphql.demographql.resolvers.Prebook;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.shackox.graphql.demographql.domain.Prebook;
import me.shackox.graphql.demographql.service.PrebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrebookMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private PrebookService prebookService;

    public Prebook createPrebook (Prebook prebook) {
        return prebookService.createPrebook(prebook);
    }

    public Prebook updatePrebook (Long prebookId, Prebook prebook) {
        return prebook;
    }

    public boolean deletePrebook (Long prebookId) {
        return false;
    }
}
