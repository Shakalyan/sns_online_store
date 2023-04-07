package com.sns.online_store.repo;

import com.sns.online_store.model.AbstractMongoDocument;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

import java.util.List;
import java.util.Optional;

public abstract class AbstractMongoRepository<T extends AbstractMongoDocument> {

    protected final MongoTemplate mongoTemplate;
    protected final Class<T> tClass;

    public AbstractMongoRepository(MongoTemplate mongoTemplate, Class<T> tClass) {
        this.mongoTemplate = mongoTemplate;
        this.tClass = tClass;
    }

    public Optional<T> findById(String objectId) {
        if (objectId == null)
            return Optional.empty();
        return Optional.ofNullable(mongoTemplate.findById(objectId, tClass));
    }

    public List<T> findAll() {
        return mongoTemplate.findAll(tClass);
    }

    public void insertOne(T object) {
        object.setId(null);
        mongoTemplate.insert(object);
    }

    public Optional<T> deleteById(String objectId) {
        String query = String.format("{id: '%s'}", objectId);
        return Optional.ofNullable(mongoTemplate.findAndRemove(new BasicQuery(query), tClass));
    }

    public boolean updateOne(T object) {
        if (findById(object.getId()).isEmpty()) {
            return false;
        }
        mongoTemplate.save(object);
        return true;
    }

}
