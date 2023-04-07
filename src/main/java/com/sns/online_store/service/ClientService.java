package com.sns.online_store.service;

import com.sns.online_store.model.Client;
import com.sns.online_store.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends AbstractDocumentService<Client> {

    @Autowired
    public ClientService(ClientRepository repository) {
        super(repository, "Client");
    }

}
