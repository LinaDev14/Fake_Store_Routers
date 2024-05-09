package com.co.linadev.fakestore.application.service.purchase.implementations;


import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.UpdatePurchase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import com.co.linadev.fakestore.domain.utils.messages.PurchaseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UpdatePurchaseUseCase implements UpdatePurchase {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Mono<PurchaseDto> updatePurchase(PurchaseDto purchaseDto) {
        Objects.requireNonNull(purchaseDto.getId(), PurchaseMessage.ID_PURCHASE_REQUIRED);

        return purchaseRepository.save(purchaseMapper.mapToCollectionPurchase()
                        .apply(purchaseDto))
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
