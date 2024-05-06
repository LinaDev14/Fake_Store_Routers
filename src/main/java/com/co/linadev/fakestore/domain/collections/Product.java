package com.co.linadev.fakestore.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "products")

public class Product {

    @Id
    private final String id;

    private final String product;
    private final Double price;
    private final String description;
    private final String category;
    private final String image;
    private final Double rate;
    private final Integer stock;


}
