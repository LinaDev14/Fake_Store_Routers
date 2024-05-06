package com.co.linadev.fakestore.domain.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDto {

    private String id;
    private String product;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Double rate;
    private Integer stock;
}
