package com.co.linadev.fakestore.application.usecases.sale;

import com.co.linadev.fakestore.application.mappers.SaleMapper;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import com.co.linadev.fakestore.domain.repository.SaleRepository;
import com.co.linadev.fakestore.domain.utils.messages.SaleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaleService implements SaleServiceInterface {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;

    @Override
    public Flux<SaleDto> fillDataSale(List<SaleDto> saleDTO) {
        return saleRepository.saveAll(saleDTO.stream()
                .map(saleMapper.mapToCollectionSale())
                .collect(Collectors.toList()))
                .map(saleMapper.mapToDtoSale());
    }

    @Override
    public Mono<SaleDto> findById(String id) {
        return saleRepository.findById(id)
                .map(saleMapper.mapToDtoSale())
                .switchIfEmpty(Mono.error(new RuntimeException(SaleMessage.NOT_REGISTERED)));
    }

    @Override
    public Flux<SaleDto> findAllSales() {
        return saleRepository.findAll()
                .map(saleMapper.mapToDtoSale());
    }

    @Override
    public Mono<SaleDto>  saveSale(SaleDto saleDTO) {
        return saleRepository.save(saleMapper.mapToCollectionSale()
                .apply(saleDTO))
                .map(saleMapper.mapToDtoSale());
    }

    @Override
    public Flux<SaleDto> findSalesByProductId(String productId) {
        return saleRepository.findSalesByProductId(productId)
                .map(saleMapper.mapToDtoSale());
    }

    @Override
    public Mono<SaleDto> findSalesByOrderId(String orderId) {
        return saleRepository.findSalesByOrderId(orderId)
                .map(saleMapper.mapToDtoSale());
    }

    @Override
    public Mono<String> deleteSale(String id) {
        return saleRepository.deleteById(id)
                .flatMap(sale -> saleRepository.deleteById(id))
                .then(Mono.just(SaleMessage.SALE_DELETE));
    }
}
