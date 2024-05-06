package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Product;
import com.co.linadev.fakestore.domain.dto.ApiProductDto;

import java.util.function.Function;

public class ApiProductMapper {

    public Function<ApiProductDto, Product> mapToDTOApiProduct(){

        return apiProductDTO -> new Product(
                apiProductDTO.getId(),
                apiProductDTO.getTitle(),
                apiProductDTO.getPrice(),
                apiProductDTO.getDescription(),
                apiProductDTO.getCategory(),
                apiProductDTO.getImage(),
                apiProductDTO.getRate(),
                apiProductDTO.getStock()
        );
    }
}
