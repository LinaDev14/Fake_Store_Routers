package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Purchase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;

import java.util.function.Function;

public class PurchaseMapper {


    public Function<Purchase, PurchaseDto> mapToDtoPurchase(){

        return purchase -> new PurchaseDto(
                purchase.getId(),
                purchase.getUserId(),
                purchase.getProductId(),
                purchase.getStatus()
        );
    }


    public Function<PurchaseDto, Purchase> mapToCollectionPurchase(){

        return purchaseDto -> new Purchase(
                purchaseDto.getId(),
                purchaseDto.getUserId(),
                purchaseDto.getProductId(),
                purchaseDto.getStatus()
        );
    }
}
