package com.co.linadev.fakestore.application.service.purchase.implementations;

import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.CreatePurchase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreatePurchaseUseCase implements CreatePurchase {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;


    @Override
    public Mono<PurchaseDto> savePurchase(PurchaseDto purchaseDto) {
        return purchaseRepository.save(purchaseMapper.mapToCollectionPurchase()
                        .apply(purchaseDto))
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
