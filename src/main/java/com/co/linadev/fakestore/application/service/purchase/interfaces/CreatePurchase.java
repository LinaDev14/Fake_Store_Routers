package com.co.linadev.fakestore.application.service.purchase.interfaces;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import reactor.core.publisher.Mono;

public interface CreatePurchase {
    Mono<PurchaseDto> savePurchase(PurchaseDto purchaseDto);
}
