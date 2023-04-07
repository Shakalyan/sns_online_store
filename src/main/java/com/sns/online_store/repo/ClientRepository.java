package com.sns.online_store.repo;

import com.sns.online_store.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository extends AbstractMongoRepository<Client> {

    @Autowired
    public ClientRepository(MongoTemplate mongoTemplate) {
        super(mongoTemplate, Client.class);
    }

}
