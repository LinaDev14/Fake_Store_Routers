package com.co.linadev.fakestore.application.service.purchase.interfaces;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import reactor.core.publisher.Flux;

public interface FindPurchasesByStatus {

    Flux<PurchaseDto> findPurchaseByStatus(Status status);
}
