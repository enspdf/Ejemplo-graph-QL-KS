package me.shackox.graphql.demographql.resolver.prebook;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.shackox.graphql.demographql.domain.Prebook;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    public List<Prebook> allPrebooksHeader () {
        return null;
    }

    public List<Prebook> allPrebooksWithDetails () {
        return null;
    }

    public Long countAllPrebooks () {
        return 0L;
    }

    public Prebook getPrebookById (Long id){
        return null;
    }
}
