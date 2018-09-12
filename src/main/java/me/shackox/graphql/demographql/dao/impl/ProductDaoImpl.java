package me.shackox.graphql.demographql.dao.impl;

import me.shackox.graphql.demographql.dao.ProductDao;
import me.shackox.graphql.demographql.domain.Product;
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
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id, description, boxes, bunches, stemsBunch, unitCost ");
        strQuery.append(" FROM  ");
        strQuery.append(" tblProduct ");

        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(Product.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("description", StandardBasicTypes.STRING);
        query.addScalar("boxes", StandardBasicTypes.INTEGER);
        query.addScalar("bunches", StandardBasicTypes.INTEGER);
        query.addScalar("stemsBunch", StandardBasicTypes.INTEGER);
        query.addScalar("unitCost", StandardBasicTypes.DOUBLE);

        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAllProducts() {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" COUNT(id) AS count ");
        strQuery.append(" FROM ");
        strQuery.append(" tblProduct ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());

        query.addScalar("count", StandardBasicTypes.LONG);

        return (Long) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Product getProductById(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" SELECT ");
        strQuery.append(" id, description, boxes, bunches, stemsBunch, unitCost ");
        strQuery.append(" FROM  ");
        strQuery.append(" tblProduct ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :productId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(Product.class));
        query.setParameter("productId", id);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("description", StandardBasicTypes.STRING);
        query.addScalar("boxes", StandardBasicTypes.INTEGER);
        query.addScalar("bunches", StandardBasicTypes.INTEGER);
        query.addScalar("stemsBunch", StandardBasicTypes.INTEGER);
        query.addScalar("unitCost", StandardBasicTypes.DOUBLE);

        return (Product) query.uniqueResult();
    }

    @Override
    @Transactional
    public boolean deleteProduct(Long id) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" DELETE ");
        strQuery.append(" FROM ");
        strQuery.append(" tblProduct ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :productId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("productId", id);

        int resultQuery = query.executeUpdate();
        return resultQuery == 1 ? true : false;
    }

    @Override
    @Transactional
    public Long createProduct(Product product) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO ");
        strQuery.append(" tblProduct ");
        strQuery.append(" (description, boxes, bunches, stemsBunch, unitCost) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:description, :boxes, :bunches, :stemsBunch, :unitCost) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("description", product.getDescription());
        query.setParameter("boxes", product.getBoxes());
        query.setParameter("bunches", product.getBunches());
        query.setParameter("stemsBunch", product.getStemsBunch());
        query.setParameter("unitCost", product.getUnitCost());

        query.executeUpdate();

        BigInteger lastInsertedId = (BigInteger) sessionFactory.getCurrentSession().createNativeQuery(" SELECT LAST_INSERT_ID() ").uniqueResult();

        return lastInsertedId.longValue();
    }

    @Override
    @Transactional
    public void updateProduct(Long id, Product product) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblProduct SET ");
        strQuery.append(" description = :description, ");
        strQuery.append(" boxes = :boxes, ");
        strQuery.append(" bunches = :bunches, ");
        strQuery.append(" stemsBunch = :stemsBunch, ");
        strQuery.append(" unitCost = :unitCost ");
        strQuery.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("description", product.getDescription());
        query.setParameter("boxes", product.getBoxes());
        query.setParameter("bunches", product.getBunches());
        query.setParameter("stemsBunch", product.getStemsBunch());
        query.setParameter("unitCost", product.getUnitCost());
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
