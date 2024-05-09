package com.co.linadev.fakestore.application.service.product.interfaces;

import com.co.linadev.fakestore.domain.dto.ProductDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface SaveAllProducts {

    Flux<ProductDto> fillData(List<ProductDto> productDto);
}
