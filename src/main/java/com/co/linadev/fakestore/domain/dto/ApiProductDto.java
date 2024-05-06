package com.co.linadev.fakestore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiProductDto {

    private String id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Double rate;
    private Integer stock;

}
