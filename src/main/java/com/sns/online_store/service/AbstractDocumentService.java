package com.sns.online_store.service;

import com.sns.online_store.exception.EntityNotFoundException;
import com.sns.online_store.model.AbstractMongoDocument;
import com.sns.online_store.repo.AbstractMongoRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDocumentService<T extends AbstractMongoDocument> {

    protected final AbstractMongoRepository<T> repository;
    protected final String documentName;

    public AbstractDocumentService(AbstractMongoRepository<T> repository, String documentName) {
        this.repository = repository;
        this.documentName = documentName;
    }

    public T findById(String objectId) {
        Optional<T> object = repository.findById(objectId);
        if (object.isEmpty()) {
            throw new EntityNotFoundException(String.format("%s with id: '%s' not found", documentName, objectId));
        }
        return object.get();
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void insertOne(T object) {
        repository.insertOne(object);
    }

    public void deleteById(String objectId) {
        if (repository.deleteById(objectId).isEmpty()) {
            throw new EntityNotFoundException(String.format("%s with id: '%s' not found", documentName, objectId));
        }
    }

    public void updateOne(T object) {
        if (!repository.updateOne(object)) {
            throw new EntityNotFoundException(String.format("%s with id: '%s' not found", documentName, object.getId()));
        }
    }

}
