package com.co.linadev.fakestore.application.service.purchase.implementations;

import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.FindPurchaseById;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import com.co.linadev.fakestore.domain.utils.messages.PurchaseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class FindPurchaseByIdUseCase implements FindPurchaseById {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;


    @Override
    public Mono<PurchaseDto> findPurchaseById(String id) {
        return purchaseRepository.findById(id)
                .map(purchaseMapper.mapToDtoPurchase())
                .switchIfEmpty(Mono.error(new RuntimeException(PurchaseMessage.PURCHASE_NOT_FOUND)));
    }
}
