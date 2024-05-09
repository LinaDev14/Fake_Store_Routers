package com.co.linadev.fakestore.application.service.purchase.interfaces;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import reactor.core.publisher.Flux;

public interface FindPurchasesByProductId {

    Flux<PurchaseDto> findPurchasesByProductId(String productId);
}
