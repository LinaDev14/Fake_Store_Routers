package com.co.linadev.fakestore.application.service.purchase.implementations;

import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.FindPurchasesByUserId;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindPurchasesByUserIdUseCase implements FindPurchasesByUserId {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;


    @Override
    public Flux<PurchaseDto> findPurchasesByUserId(String userId) {
        return purchaseRepository.findPurchasesByUserId(userId)
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
