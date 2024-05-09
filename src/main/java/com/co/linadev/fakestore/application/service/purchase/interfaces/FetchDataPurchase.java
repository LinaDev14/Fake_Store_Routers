package com.co.linadev.fakestore.application.service.purchase.interfaces;

import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface FetchDataPurchase {

    Flux<PurchaseDto> saveAllPurchase(List<PurchaseDto> purchaseDto);
}


