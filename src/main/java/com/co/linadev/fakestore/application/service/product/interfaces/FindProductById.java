package com.co.linadev.fakestore.application.service.product.interfaces;

import com.co.linadev.fakestore.domain.dto.ProductDto;
import reactor.core.publisher.Mono;

public interface FindProductById {
    Mono<ProductDto> findById(String id);
}
