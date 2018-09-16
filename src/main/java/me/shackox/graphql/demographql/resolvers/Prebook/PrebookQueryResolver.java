package me.shackox.graphql.demographql.resolvers.Prebook;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.shackox.graphql.demographql.domain.Prebook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrebookQueryResolver implements GraphQLQueryResolver {
    public List<Prebook> allPrebooksHeader() {
        return null;
    }

    public List<Prebook> allPrebooksWithDetails() {
        return null;
    }

    public Long countAllPrebooks() {
        return 0L;
    }

    public Prebook getPrebookById(Long id) {
        return null;
    }
}
