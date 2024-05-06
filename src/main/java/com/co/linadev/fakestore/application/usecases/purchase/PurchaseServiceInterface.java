package com.co.linadev.fakestore.application.usecases.purchase;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PurchaseServiceInterface {

    // create purchase
    Mono<PurchaseDto> savePurchase(PurchaseDto purchaseDto);

    // fill Data
    Flux<PurchaseDto> saveAllPurchase(List<PurchaseDto> purchaseDto);

    // find purchase by id
    Mono<PurchaseDto> findPurchaseById(String id);

    // find all purchase
    Flux<PurchaseDto> listPurchases();

    // find purchases by id user
    Flux<PurchaseDto> findPurchasesByUserId(String userId);

    // find purchases by product
    Flux<PurchaseDto> findPurchasesByProductId(String productId);

    // updated purchase
    Mono<PurchaseDto> updatePurchase(PurchaseDto purchaseDto);

    // find purchase by status
    Flux<PurchaseDto> findPurchaseByStatus(Status status);


}
