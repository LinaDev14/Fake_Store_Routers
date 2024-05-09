package com.co.linadev.fakestore.application.service.purchase.implementations;

import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.FindAllPurchases;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindAllPurchasesUseCase implements FindAllPurchases {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Flux<PurchaseDto> listPurchases() {
        return purchaseRepository.findAll()
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
