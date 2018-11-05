package me.shackox.graphql.demographql.resolvers.PrebookItem;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import me.shackox.graphql.demographql.domain.PrebookItem;
import me.shackox.graphql.demographql.service.PrebookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrebookItemQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private PrebookItemService prebookItemService;

    public List<PrebookItem> getPrebookItemsByPrebook(Long id) {
        return prebookItemService.getPrebookItemsByPrebookId(id);
    }

    public PrebookItem getPrebookItemById(Long id) {
        return prebookItemService.getPrebookItemById(id);
    }
}
