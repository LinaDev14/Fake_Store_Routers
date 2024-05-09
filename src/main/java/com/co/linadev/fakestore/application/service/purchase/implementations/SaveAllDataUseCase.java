package com.co.linadev.fakestore.application.service.purchase.implementations;


import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.application.service.purchase.interfaces.FetchDataPurchase;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SaveAllDataUseCase implements FetchDataPurchase {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Flux<PurchaseDto> saveAllPurchase(List<PurchaseDto> purchaseDto) {
        return purchaseRepository.saveAll(purchaseDto.stream()
                        .map(purchaseMapper.mapToCollectionPurchase())
                        .collect(Collectors.toList()))
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
