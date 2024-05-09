package com.co.linadev.fakestore.application.service.product.interfaces;

import com.co.linadev.fakestore.domain.dto.ProductDto;
import reactor.core.publisher.Flux;

public interface FindAllByPriceLessThan {

    Flux<ProductDto> findAllByPriceLessThan(Double productPrice);
}
