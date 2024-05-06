package com.co.linadev.fakestore.application.usecases.product;

import com.co.linadev.fakestore.domain.dto.ProductDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductServiceInterface {

    // list products
    Flux<ProductDto> listProduct();

    // find by id
    Mono<ProductDto> findById(String id);

    // fill data
    Flux<ProductDto> fillData(List<ProductDto> productDto);

    // save product
    Mono<ProductDto> saveProduct(ProductDto productDto);

    // find by productName
    Flux<ProductDto> findAllByProductName(String productName);

    // find by price less than
    Flux<ProductDto> findAllByPriceLessThan(Double productPrice);

    // find by price greater than
    Flux<ProductDto> findAllByPriceGreaterThan(Double productPrice);

    // find all products by price
    Flux<ProductDto> findAllByPrice(Double productPrice);

    //fetch Data
    Flux<ProductDto> fetchData();



}
