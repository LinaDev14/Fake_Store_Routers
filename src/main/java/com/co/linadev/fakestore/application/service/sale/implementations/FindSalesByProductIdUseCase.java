package com.co.linadev.fakestore.application.service.sale.implementations;

import com.co.linadev.fakestore.application.mappers.SaleMapper;
import com.co.linadev.fakestore.application.service.sale.interfaces.FindSalesByProductId;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import com.co.linadev.fakestore.domain.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindSalesByProductIdUseCase implements FindSalesByProductId {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;


    @Override
    public Flux<SaleDto> findSalesByProductId(String productId) {
        return saleRepository.findSalesByProductId(productId)
                .map(saleMapper.mapToDtoSale());
    }
}
