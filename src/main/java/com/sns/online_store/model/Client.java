package com.sns.online_store.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client extends AbstractMongoDocument {

    String name;

    String phoneNumber;

    String email;

    List<Product> cart;

}
