package me.shackox.graphql.demographql.dao.impl;

import me.shackox.graphql.demographql.dao.ProductDao;
import me.shackox.graphql.demographql.domain.Product;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
        strQuery.append(" id, description ");
        strQuery.append(" FROM  ");
        strQuery.append(" tblProduct ");

        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(Product.class));

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("description", StandardBasicTypes.STRING);

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
        strQuery.append(" id, description ");
        strQuery.append(" FROM  ");
        strQuery.append(" tblProduct ");
        strQuery.append(" WHERE ");
        strQuery.append(" id = :productId ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setResultTransformer(Transformers.aliasToBean(Product.class));
        query.setParameter("productId", id);

        query.addScalar("id", StandardBasicTypes.LONG);
        query.addScalar("description", StandardBasicTypes.STRING);

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
        return resultQuery == 1;
    }

    @Override
    @Transactional
    public Long createProduct(String productDescription) {
        Assert.isTrue(StringUtils.isNotBlank(productDescription), "Product Description is required");

        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" INSERT INTO ");
        strQuery.append(" tblProduct ");
        strQuery.append(" (description) ");
        strQuery.append(" VALUES ");
        strQuery.append(" (:description) ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("description", productDescription);

        query.executeUpdate();

        BigInteger lastInsertedId = (BigInteger) sessionFactory.getCurrentSession().createNativeQuery(" SELECT LAST_INSERT_ID() ").uniqueResult();

        return lastInsertedId.longValue();
    }

    @Override
    @Transactional
    public void updateProduct(Long id, String productDescription) {
        Assert.isTrue(id != null && id > NumberUtils.INTEGER_ZERO, "Product Id is required");
        Assert.isTrue(StringUtils.isNotBlank(productDescription), "Product Description is required");

        StringBuilder strQuery = new StringBuilder();
        strQuery.append(" UPDATE ");
        strQuery.append(" tblProduct SET ");
        strQuery.append(" description = :description ");
        strQuery.append(" WHERE id = :id ");

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString());
        query.setParameter("description", productDescription);
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
