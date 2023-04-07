package com.sns.online_store.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends AbstractMongoDocument {

    String name;

    Integer amount;

    Integer price;

    String manufacturer;

    String category;

}
