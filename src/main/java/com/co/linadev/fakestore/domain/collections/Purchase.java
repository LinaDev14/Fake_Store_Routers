package com.co.linadev.fakestore.domain.collections;

import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "purchases")
public class Purchase {

    @Id
    private final String id;

    private final String userId;
    private final String productId;
    private final Status status;
}
