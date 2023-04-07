package com.sns.online_store.repo;

import com.sns.online_store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends AbstractMongoRepository<Product> {

    @Autowired
    public ProductRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Product.class);
    }

}
