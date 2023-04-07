package com.sns.online_store.repo;

import com.sns.online_store.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends AbstractMongoRepository<Order> {

    @Autowired
    public OrderRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Order.class);
    }

}
