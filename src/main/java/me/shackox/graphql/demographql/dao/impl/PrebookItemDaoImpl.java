package me.shackox.graphql.demographql.dao.impl;

import me.shackox.graphql.demographql.dao.PrebookItemDao;
import me.shackox.graphql.demographql.domain.PrebookItem;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Repository
public class PrebookItemDaoImpl implements PrebookItemDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public PrebookItem getPrebookItemById(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id, prebookId, productId, vendorCode, boxType, unitType, markCode, unitPrice ");
        strQuery.append(" FROM ");
        strQuery.append(" tblPrebookItem ");
        strQuery.append(" WHERE id = :prebookItemId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(PrebookItem.class));
        query.setParameter("prebookItemId", id);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("prebookId", StandardBasicTypes.LONG);
        query.addScalar("productId", StandardBasicTypes.LONG);
        query.addScalar("vendorCode", StandardBasicTypes.STRING);
        query.addScalar("boxType", StandardBasicTypes.STRING);
        query.addScalar("unitType", StandardBasicTypes.STRING);
        query.addScalar("markCode", StandardBasicTypes.STRING);
        query.addScalar("unitPrice", StandardBasicTypes.DOUBLE);

        return (PrebookItem) query.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrebookItem> getPrebookItemsByPrebookId(Long prebookId) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id, prebookId, productId, vendorCode, boxType, unitType, markCode, unitPrice ");
        strQuery.append(" FROM ");
        strQuery.append(" tblPrebookItem ");
        strQuery.append(" WHERE prebookId = :prebookId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(PrebookItem.class));
        query.setParameter("prebookId", prebookId);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("prebookId", StandardBasicTypes.LONG);
        query.addScalar("productId", StandardBasicTypes.LONG);
        query.addScalar("vendorCode", StandardBasicTypes.STRING);
        query.addScalar("boxType", StandardBasicTypes.STRING);
        query.addScalar("unitType", StandardBasicTypes.STRING);
        query.addScalar("markCode", StandardBasicTypes.STRING);
        query.addScalar("unitPrice", StandardBasicTypes.DOUBLE);

        return query.getResultList();
    }

    @Override
    @Transactional
    public Long createPrebookItem(PrebookItem prebookItem) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO ");
        strQuery.append(" tblPrebookItem ");
        strQuery.append(" (prebookId, productId, vendorCode, boxType, unitType, markCode, unitPrice) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:prebookId, :productId, :vendorCode, :boxType, :unitType, :markCode, :unitPrice) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("prebookId", prebookItem.getPrebookId());
        query.setParameter("productId", prebookItem.getProductId());
        query.setParameter("vendorCode", prebookItem.getVendorCode());
        query.setParameter("boxType", prebookItem.getBoxType());
        query.setParameter("unitType", prebookItem.getUnitType());
        query.setParameter("markCode", prebookItem.getMarkCode());
        query.setParameter("unitPrice", prebookItem.getUnitPrice());

        query.executeUpdate();

        BigInteger lastInsertedId = (BigInteger) sessionFactory.getCurrentSession().createNativeQuery(" SELECT LAST_INSERT_ID() ").uniqueResult();

        return lastInsertedId.longValue();
    }

    @Override
    @Transactional
    public void updatePrebookItem(Long prebookItemId, PrebookItem prebookItem) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblPrebookItem SET ");
        strQuery.append(" productId = :productId, ");
        strQuery.append(" vendorCode = :vendorCode, ");
        strQuery.append(" boxType = :boxType, ");
        strQuery.append(" unitType = :unitType, ");
        strQuery.append(" markCode = :markCode, ");
        strQuery.append(" unitPrice = :unitPrice ");
        strQuery.append(" WHERE id = :prebookItemId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("productId", prebookItem.getProductId());
        query.setParameter("vendorCode", prebookItem.getVendorCode());
        query.setParameter("boxType", prebookItem.getBoxType());
        query.setParameter("unitType", prebookItem.getUnitType());
        query.setParameter("markCode", prebookItem.getMarkCode());
        query.setParameter("unitPrice", prebookItem.getUnitPrice());
        query.setParameter("prebookItemId", prebookItemId);

        query.executeUpdate();
    }

    @Override
    @Transactional
    public boolean deletePrebookItem(Long prebookItemId) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblPrebookItem ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :prebookItemId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("prebookItemId", prebookItemId);

        int resultQuery = query.executeUpdate();
        return resultQuery == 1;
    }
}
