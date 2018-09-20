package me.shackox.graphql.demographql.service.impl;

import me.shackox.graphql.demographql.dao.PrebookItemDao;
import me.shackox.graphql.demographql.domain.PrebookItem;
import me.shackox.graphql.demographql.service.PrebookItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrebookItemServiceImpl implements PrebookItemService {
    @Autowired
    private PrebookItemDao prebookItemDao;

    @Override
    public PrebookItem getPrebookItemById(Long id) {
        return prebookItemDao.getPrebookItemById(id);
    }

    @Override
    public List<PrebookItem> getPrebookItemsByPrebookId(Long prebookId) {
        return prebookItemDao.getPrebookItemsByPrebookId(prebookId);
    }

    @Override
    public Long createPrebookItem(PrebookItem prebookItem) {
        return prebookItemDao.createPrebookItem(prebookItem);
    }
}
