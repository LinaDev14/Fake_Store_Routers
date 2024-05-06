package com.co.linadev.fakestore.domain.dto;

import com.co.linadev.fakestore.domain.utils.valueObjects.ProductRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {

    private String id;
    private String userId;
    private String productId;
    private String comment;
    private double rating;
}
