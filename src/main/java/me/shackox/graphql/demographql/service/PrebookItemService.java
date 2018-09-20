package me.shackox.graphql.demographql.service;

import me.shackox.graphql.demographql.domain.PrebookItem;

import java.util.List;

public interface PrebookItemService {
    PrebookItem getPrebookItemById(Long id);

    List<PrebookItem> getPrebookItemsByPrebookId(Long prebookId);

    Long createPrebookItem(PrebookItem prebookItem);
}
