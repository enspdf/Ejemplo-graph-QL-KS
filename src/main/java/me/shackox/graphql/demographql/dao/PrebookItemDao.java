package me.shackox.graphql.demographql.dao;

import me.shackox.graphql.demographql.domain.PrebookItem;

public interface PrebookItemDao {
    PrebookItem getPrebookItemById(Long id);

    PrebookItem createPrebookItem(PrebookItem prebookItem);
}
