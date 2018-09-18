package me.shackox.graphql.demographql.service.impl;

import me.shackox.graphql.demographql.dao.PrebookDao;
import me.shackox.graphql.demographql.domain.Prebook;
import me.shackox.graphql.demographql.domain.PrebookItem;
import me.shackox.graphql.demographql.service.PrebookItemService;
import me.shackox.graphql.demographql.service.PrebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrebookServiceImpl implements PrebookService {
    @Autowired
    private PrebookDao prebookDao;

    @Autowired
    private PrebookItemService prebookItemService;

    @Override
    public List<Prebook> allPrebooksHeader() {
        return prebookDao.allPrebooksHeader();
    }

    @Override
    public List<Prebook> allPrebooksWithDetails() {
        return prebookDao.allPrebooksWithDetails();
    }

    @Override
    public Long countAllPrebooks() {
        return prebookDao.countAllPrebooks();
    }

    @Override
    public Prebook getPrebookById(Long id) {
        return prebookDao.getPrebookById(id);
    }

    @Override
    public Prebook createPrebookHeader(Prebook prebook) {
        Long prebookId = prebookDao.createPrebook(prebook);
        return prebookDao.getPrebookById(prebookId);
    }

    @Override
    public Prebook createPrebookWithItems(Prebook prebook) {
        Long prebookId = prebookDao.createPrebook(prebook);
        Prebook prebookSaved = prebookDao.getPrebookById(prebookId);
        // TODO
        return prebookSaved;
    }

    @Override
    public Prebook updatePrebookHeader(Long prebookId, Prebook prebook) {
        return prebookDao.updatePrebookHeader(prebookId, prebook);
    }

    @Override
    public Prebook updatePrebookWithItems(Long prebookId, Prebook prebook) {
        return prebookDao.updatePrebookWithItems(prebookId, prebook);
    }

    @Override
    public boolean deletePrebook(Long prebookId) {
        return prebookDao.deletePrebook(prebookId);
    }

    private void processPrebookItems (List<PrebookItem> prebookItems) {

    }
}
