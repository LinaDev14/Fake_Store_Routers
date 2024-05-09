package com.co.linadev.fakestore.application.service.sale.interfaces;

import com.co.linadev.fakestore.domain.dto.SaleDto;
import reactor.core.publisher.Flux;

public interface FindSalesByProductId {

    Flux<SaleDto> findSalesByProductId(String productId);
}
