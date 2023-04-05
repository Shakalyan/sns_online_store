package com.sns.online_store.repo;

import com.sns.online_store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Product> getAllProducts() {
        return mongoTemplate.findAll(Product.class);
    }

}
