package com.co.linadev.fakestore.application.service.sale.interfaces;

import com.co.linadev.fakestore.domain.dto.SaleDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface FillDataSale {

    Flux<SaleDto> fillDataSale(List<SaleDto> saleDTO);
}
