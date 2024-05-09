package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Product;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper {

    public Function<Product, ProductDto> mapToDtoProduct(){

        return product -> new ProductDto(
                product.getId(),
                product.getProduct(),
                product.getPrice(),
                product.getDescription(),
                product.getCategory(),
                product.getImage(),
                product.getRate(),
                product.getStock()
        );
    }

    public Function<ProductDto, Product> mapToCollectionProduct(){

        return productDto -> new Product(
                productDto.getId(),
                productDto.getProduct(),
                productDto.getPrice(),
                productDto.getDescription(),
                productDto.getCategory(),
                productDto.getImage(),
                productDto.getRate(),
                productDto.getStock()
        );
    }
}
