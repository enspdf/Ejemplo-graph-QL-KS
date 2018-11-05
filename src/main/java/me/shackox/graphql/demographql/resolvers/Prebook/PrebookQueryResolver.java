package me.shackox.graphql.demographql.resolvers.Prebook;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.shackox.graphql.demographql.domain.Prebook;
import me.shackox.graphql.demographql.service.PrebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrebookQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private PrebookService prebookService;

    public List<Prebook> getAllPrebooks() {
        return prebookService.getAllPrebooks();
    }

    public Long countAllPrebooks() {
        return prebookService.countAllPrebooks();
    }

    public Prebook getPrebookById(Long id) {
        return prebookService.getPrebookById(id);
    }
}
