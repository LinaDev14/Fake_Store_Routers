package com.co.linadev.fakestore.application.service.product.interfaces;

import com.co.linadev.fakestore.domain.dto.ProductDto;
import reactor.core.publisher.Flux;

public interface FindAllByPrice {

    Flux<ProductDto> findAllByPrice(Double productPrice);
}
