package com.co.linadev.fakestore.domain.collections;


import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(value = "Orders")
public class Order {

    @Id
    private final String id;

    private final String userId;
    private final String productId;
    private final String paymentId;
    private final Integer quantity;
    private final Double totalOrder;
    private final Status status;
    private final String statusDescription;
    private final Date orderDate;

}
