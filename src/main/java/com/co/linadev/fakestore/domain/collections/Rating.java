package com.co.linadev.fakestore.domain.collections;

import com.co.linadev.fakestore.domain.utils.valueObjects.ProductRating;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Ratings")
public class Rating {

    @Id
    private final String id;

    private final String userId;
    private final String productId;
    private final String comment;
    private final double rating;


}
