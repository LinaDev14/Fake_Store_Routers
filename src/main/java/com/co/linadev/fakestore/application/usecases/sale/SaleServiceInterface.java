package com.co.linadev.fakestore.application.usecases.sale;

import com.co.linadev.fakestore.domain.dto.SaleDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public interface SaleServiceInterface {

    //save all data
    Flux<SaleDto> fillDataSale(List<SaleDto> saleDTO);

    // find by id
    Mono<SaleDto> findById(String id);

    // find all sales
    Flux<SaleDto> findAllSales();

    // save user
    Mono<SaleDto> saveSale(SaleDto saleDTO);

    Flux<SaleDto> findSalesByProductId(String productId);

    Mono<SaleDto> findSalesByOrderId(String orderId);

    Mono<String> deleteSale(String id);
}
