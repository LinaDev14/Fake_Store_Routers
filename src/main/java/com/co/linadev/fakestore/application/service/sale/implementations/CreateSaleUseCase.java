package com.co.linadev.fakestore.application.service.sale.implementations;


import com.co.linadev.fakestore.application.mappers.SaleMapper;
import com.co.linadev.fakestore.application.service.sale.interfaces.CreateSale;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import com.co.linadev.fakestore.domain.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateSaleUseCase implements CreateSale {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;


    @Override
    public Mono<SaleDto> saveSale(SaleDto saleDTO) {
        return saleRepository.save(saleMapper.mapToCollectionSale()
                        .apply(saleDTO))
                .map(saleMapper.mapToDtoSale());
    }
}
