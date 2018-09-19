package me.shackox.graphql.demographql.dao.impl;

import me.shackox.graphql.demographql.dao.PrebookItemDao;
import me.shackox.graphql.demographql.domain.PrebookItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PrebookItemDaoImpl implements PrebookItemDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public PrebookItem getPrebookItemById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public PrebookItem createPrebookItem(PrebookItem prebookItem) {
        return null;
    }
}
