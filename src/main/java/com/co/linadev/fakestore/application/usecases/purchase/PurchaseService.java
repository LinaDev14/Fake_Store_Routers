package com.co.linadev.fakestore.application.usecases.purchase;

import com.co.linadev.fakestore.application.mappers.PurchaseMapper;
import com.co.linadev.fakestore.domain.dto.PurchaseDto;
import com.co.linadev.fakestore.domain.repository.PurchaseRepository;
import com.co.linadev.fakestore.domain.utils.messages.PurchaseMessage;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PurchaseService implements PurchaseServiceInterface{

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    public Mono<PurchaseDto> savePurchase(PurchaseDto purchaseDto) {
        return purchaseRepository.save(purchaseMapper.mapToCollectionPurchase()
                .apply(purchaseDto))
                .map(purchaseMapper.mapToDtoPurchase());
    }

    @Override
    public Flux<PurchaseDto> saveAllPurchase(List<PurchaseDto> purchaseDto) {
        return purchaseRepository.saveAll(purchaseDto.stream()
                .map(purchaseMapper.mapToCollectionPurchase())
                .collect(Collectors.toList()))
                .map(purchaseMapper.mapToDtoPurchase());
    }

    @Override
    public Mono<PurchaseDto> findPurchaseById(String id) {
        return purchaseRepository.findById(id)
                .map(purchaseMapper.mapToDtoPurchase())
                .switchIfEmpty(Mono.error(new RuntimeException(PurchaseMessage.PURCHASE_NOT_FOUND)));
    }

    @Override
    public Flux<PurchaseDto> listPurchases() {
        return purchaseRepository.findAll()
                .map(purchaseMapper.mapToDtoPurchase());
    }

    @Override
    public Flux<PurchaseDto> findPurchasesByUserId(String userId) {
        return purchaseRepository.findPurchasesByUserId(userId)
                .map(purchaseMapper.mapToDtoPurchase());

    }

    @Override
    public Flux<PurchaseDto> findPurchasesByProductId(String productId) {
        return purchaseRepository.findPurchasesByProductId(productId)
                .map(purchaseMapper.mapToDtoPurchase());
    }

    @Override
    public Mono<PurchaseDto> updatePurchase(PurchaseDto purchaseDto) {

        Objects.requireNonNull(purchaseDto.getId(), PurchaseMessage.ID_PURCHASE_REQUIRED);

        return purchaseRepository.save(purchaseMapper.mapToCollectionPurchase()
                .apply(purchaseDto))
                .map(purchaseMapper.mapToDtoPurchase());
    }

    @Override
    public Flux<PurchaseDto> findPurchaseByStatus(Status status) {
        return purchaseRepository.findPurchaseByStatus(status)
                .map(purchaseMapper.mapToDtoPurchase());
    }
}
