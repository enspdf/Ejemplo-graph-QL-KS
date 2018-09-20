package me.shackox.graphql.demographql.service.impl;

import me.shackox.graphql.demographql.dao.PrebookDao;
import me.shackox.graphql.demographql.domain.Prebook;
import me.shackox.graphql.demographql.domain.PrebookItem;
import me.shackox.graphql.demographql.service.PrebookItemService;
import me.shackox.graphql.demographql.service.PrebookService;
import org.apache.commons.collections4.CollectionUtils;
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
    public List<Prebook> getAllPrebooks() {
        return prebookDao.getAllPrebooks();
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
    public Prebook createPrebook(Prebook prebook) {
        Long prebookId = prebookDao.createPrebook(prebook);

        if (CollectionUtils.isNotEmpty(prebook.getPrebookItems())) {
            prebook.getPrebookItems().forEach(prebookItem -> {
                prebookItem.setPrebookId(prebookId);
                prebookItemService.createPrebookItem(prebookItem);

            });
        }

        Prebook prebookCreated = prebookDao.getPrebookById(prebookId);

        List<PrebookItem> prebookItemList = prebookItemService.getPrebookItemsByPrebookId(prebookId);

        if (CollectionUtils.isNotEmpty(prebookItemList)) {
            prebookCreated.setPrebookItems(prebookItemList);
        }

        return prebookCreated;
    }

    @Override
    public Prebook updatePrebook(Long prebookId, Prebook prebook) {
        return prebookDao.updatePrebook(prebookId, prebook);
    }

    @Override
    public boolean deletePrebook(Long prebookId) {
        return prebookDao.deletePrebook(prebookId);
    }

    private void processPrebookItems (List<PrebookItem> prebookItems) {

    }
}
