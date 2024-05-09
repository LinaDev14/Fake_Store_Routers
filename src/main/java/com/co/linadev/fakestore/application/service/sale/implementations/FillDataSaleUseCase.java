package com.co.linadev.fakestore.application.service.sale.implementations;

import com.co.linadev.fakestore.application.mappers.SaleMapper;
import com.co.linadev.fakestore.application.service.sale.interfaces.FillDataSale;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import com.co.linadev.fakestore.domain.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillDataSaleUseCase implements FillDataSale {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;


    @Override
    public Flux<SaleDto> fillDataSale(List<SaleDto> saleDTO) {
        return saleRepository.saveAll(saleDTO.stream()
                        .map(saleMapper.mapToCollectionSale())
                        .collect(Collectors.toList()))
                .map(saleMapper.mapToDtoSale());
    }
}
