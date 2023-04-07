package com.sns.online_store.service;

import com.sns.online_store.model.Order;
import com.sns.online_store.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractDocumentService<Order> {

    @Autowired
    public OrderService(OrderRepository repository) {
        super(repository, "Order");
    }

}
