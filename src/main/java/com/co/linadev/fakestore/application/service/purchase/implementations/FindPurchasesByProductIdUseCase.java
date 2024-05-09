package com.co.linadev.fakestore.application.service.purchase.implementations;


import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.FindPurchasesByProductId;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindPurchasesByProductIdUseCase implements FindPurchasesByProductId {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Flux<PurchaseDto> findPurchasesByProductId(String productId) {
        return purchaseRepository.findPurchasesByProductId(productId)
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
