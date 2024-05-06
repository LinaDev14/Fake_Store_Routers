package com.co.linadev.fakestore.domain.collections;

import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(value = "shipments")
public class Shipping {

    @Id
    private final String id;

    private final String orderId;
    private final ShippingCompany shippingCompany;
    private final Status status;
    private final Date shappingDate;
    private final Date estimatedDeliveryDate;
}
