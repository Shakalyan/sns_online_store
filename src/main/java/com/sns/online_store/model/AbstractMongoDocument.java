package com.sns.online_store.model;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractMongoDocument {

    @Getter
    @Setter
    private String id;

}
