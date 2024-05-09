package com.co.linadev.fakestore.application.service.sale.interfaces;

import com.co.linadev.fakestore.domain.dto.SaleDto;
import reactor.core.publisher.Mono;

public interface FindSaleById {

    Mono<SaleDto> findById(String id);
}
