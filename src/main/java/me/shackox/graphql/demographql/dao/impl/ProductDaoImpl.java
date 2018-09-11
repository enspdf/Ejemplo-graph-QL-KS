package me.shackox.graphql.demographql.dao.impl;

import me.shackox.graphql.demographql.dao.ProductDao;
import me.shackox.graphql.demographql.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString(), Product.class);

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

        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(strQuery.toString(), Product.class);
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
}
