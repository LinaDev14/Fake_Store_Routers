package com.co.linadev.fakestore.application.service.purchase.implementations;

import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.FindPurchasesByStatus;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindPurchasesByStatusUseCase implements FindPurchasesByStatus {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Flux<PurchaseDto> findPurchaseByStatus(Status status) {
        return purchaseRepository.findPurchaseByStatus(status)
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
