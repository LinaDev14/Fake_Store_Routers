package com.co.linadev.fakestore.application.service.sale.implementations;

import com.co.linadev.fakestore.application.mappers.SaleMapper;
import com.co.linadev.fakestore.application.service.sale.interfaces.DeleteSale;
import com.co.linadev.fakestore.domain.repository.SaleRepository;
import com.co.linadev.fakestore.domain.utils.messages.SaleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteSaleUseCase implements DeleteSale {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;


    @Override
    public Mono<String> deleteSale(String id) {
        return saleRepository.deleteById(id)
                .flatMap(sale -> saleRepository.deleteById(id))
                .then(Mono.just(SaleMessage.SALE_DELETE));
    }
}
