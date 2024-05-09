package com.co.linadev.fakestore.application.service.purchase.interfaces;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import reactor.core.publisher.Mono;

public interface UpdatePurchase {

    Mono<PurchaseDto> updatePurchase(PurchaseDto purchaseDto);
}
