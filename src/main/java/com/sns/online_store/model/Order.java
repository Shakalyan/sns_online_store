package com.sns.online_store.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends AbstractMongoDocument {

    String clientId;

    List<Product> products;

    Date date;

    String address;

    String status;

}
