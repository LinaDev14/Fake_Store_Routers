package com.co.linadev.fakestore.application.service.purchase.interfaces;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import reactor.core.publisher.Flux;

public interface FindAllPurchases {

    Flux<PurchaseDto> listPurchases();
}
