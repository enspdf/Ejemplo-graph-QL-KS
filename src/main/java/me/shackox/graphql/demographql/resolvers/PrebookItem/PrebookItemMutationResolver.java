package me.shackox.graphql.demographql.resolvers.PrebookItem;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import me.shackox.graphql.demographql.domain.PrebookItem;
import me.shackox.graphql.demographql.service.PrebookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrebookItemMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private PrebookItemService prebookItemService;

    public PrebookItem addPrebookItem(PrebookItem prebookItem) {
        Long prebookItemId = prebookItemService.createPrebookItem(prebookItem);
        return prebookItemService.getPrebookItemById(prebookItemId);
    }

    public PrebookItem updatePrebookItem(Long prebookItemId, PrebookItem prebookItem) {
        return prebookItemService.updatePrebookItem(prebookItemId, prebookItem);
    }

    public boolean deletePrebookItem(Long id) {
        return prebookItemService.deletePrebookItem(id);
    }
}
