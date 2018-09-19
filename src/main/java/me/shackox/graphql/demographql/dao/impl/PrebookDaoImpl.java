package me.shackox.graphql.demographql.dao.impl;

import me.shackox.graphql.demographql.dao.PrebookDao;
import me.shackox.graphql.demographql.domain.Prebook;
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
public class PrebookDaoImpl implements PrebookDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Prebook> getAllPrebooks() {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id, customerName, carrierName, customerPoNumber, shipDate ");
        strQuery.append(" FROM ");
        strQuery.append(" tblPrebook ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(Prebook.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("customerName", StandardBasicTypes.STRING);
        query.addScalar("carrierName", StandardBasicTypes.STRING);
        query.addScalar("customerPoNumber", StandardBasicTypes.STRING);
        query.addScalar("shipDate", StandardBasicTypes.DATE);

        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAllPrebooks() {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" COUNT(id) AS count ");
        strQuery.append(" FROM ");
        strQuery.append(" tblPrebook ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.addScalar("count", StandardBasicTypes.LONG);

        return (Long) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Prebook getPrebookById(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id, customerName, carrierName, customerPoNumber, shipDate ");
        strQuery.append(" FROM ");
        strQuery.append(" tblPrebook ");
        strQuery.append(" WHERE id = :prebookId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(Prebook.class));
        query.setParameter("prebookId", id);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("customerName", StandardBasicTypes.STRING);
        query.addScalar("carrierName", StandardBasicTypes.STRING);
        query.addScalar("customerPoNumber", StandardBasicTypes.STRING);
        query.addScalar("shipDate", StandardBasicTypes.TIMESTAMP);

        return (Prebook) query.getSingleResult();
    }

    @Override
    @Transactional
    public Long createPrebook(Prebook prebook) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO ");
        strQuery.append(" tblPrebook ");
        strQuery.append(" (customerName, carrierName, customerPoNumber, shipDate) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:customerName, :carrierName, :customerPoNumber, :shipDate) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("customerName", prebook.getCustomerName());
        query.setParameter("carrierName", prebook.getCarrierName());
        query.setParameter("customerPoNumber", prebook.getCustomerPoNumber());
        query.setParameter("shipDate", prebook.getShipDate());

        query.executeUpdate();

        BigInteger lastInsertedId = (BigInteger) sessionFactory.getCurrentSession().createNativeQuery(" SELECT LAST_INSERT_ID() ").uniqueResult();

        return lastInsertedId.longValue();
    }

    @Override
    @Transactional
    public Prebook updatePrebook(Long prebookId, Prebook prebook) {
        return null;
    }

    @Override
    @Transactional
    public boolean deletePrebook(Long prebookId) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblPrebook ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :prebookId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("prebookId", prebookId);

        int resultQuery = query.executeUpdate();
        return resultQuery == 1;
    }
}
