package com.co.linadev.fakestore.domain.collections;

import com.co.linadev.fakestore.domain.utils.valueObjects.PaymentMethod;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "payments")
public class Payment {

    @Id
    private final String id;
    private final PaymentMethod paymentMethod;
    private final String details;
}
