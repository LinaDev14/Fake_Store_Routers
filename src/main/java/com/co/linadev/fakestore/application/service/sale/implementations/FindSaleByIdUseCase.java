package com.co.linadev.fakestore.application.service.sale.implementations;

import com.co.linadev.fakestore.application.mappers.SaleMapper;
import com.co.linadev.fakestore.application.service.sale.interfaces.FindSaleById;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import com.co.linadev.fakestore.domain.repository.SaleRepository;
import com.co.linadev.fakestore.domain.utils.messages.SaleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindSaleByIdUseCase implements FindSaleById {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;


    @Override
    public Mono<SaleDto> findById(String id) {
        return saleRepository.findById(id)
                .map(saleMapper.mapToDtoSale())
                .switchIfEmpty(Mono.error(new RuntimeException(SaleMessage.NOT_REGISTERED)));
    }
}
