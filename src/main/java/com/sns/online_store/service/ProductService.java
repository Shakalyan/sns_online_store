package com.sns.online_store.service;

import com.sns.online_store.model.Product;
import com.sns.online_store.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractDocumentService<Product> {

    @Autowired
    public ProductService(ProductRepository repository) {
        super(repository, "Product");
    }

}
