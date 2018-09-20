package me.shackox.graphql.demographql.dao;

import me.shackox.graphql.demographql.domain.PrebookItem;

import java.util.List;

public interface PrebookItemDao {
    PrebookItem getPrebookItemById(Long id);

    List<PrebookItem> getPrebookItemsByPrebookId(Long prebookId);

    Long createPrebookItem(PrebookItem prebookItem);
}
