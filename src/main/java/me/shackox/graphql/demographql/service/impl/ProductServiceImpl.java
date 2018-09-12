package me.shackox.graphql.demographql.service.impl;

import me.shackox.graphql.demographql.dao.ProductDao;
import me.shackox.graphql.demographql.domain.Product;
import me.shackox.graphql.demographql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Long countAllProducts() {
        return productDao.countAllProducts();
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public Product createProduct(Product product) {
        Long productId = productDao.createProduct(product);
        return getProductById(productId);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        productDao.updateProduct(id, product);
        return productDao.getProductById(id);
    }
}
