package me.shackox.graphql.demographql.service;

import me.shackox.graphql.demographql.domain.PrebookItem;

public interface PrebookItemService {
    PrebookItem getPrebookItemById(Long id);

    PrebookItem createPrebookItem(PrebookItem prebookItem);
}
