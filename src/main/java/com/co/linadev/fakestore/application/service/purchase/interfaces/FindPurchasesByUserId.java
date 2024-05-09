package com.co.linadev.fakestore.application.service.purchase.interfaces;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import reactor.core.publisher.Flux;

public interface FindPurchasesByUserId {

    Flux<PurchaseDto> findPurchasesByUserId(String userId);
}
