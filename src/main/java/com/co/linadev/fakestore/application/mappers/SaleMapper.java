package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Sale;
import com.co.linadev.fakestore.domain.dto.SaleDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SaleMapper {

    public Function<Sale, SaleDto> mapToDtoSale(){

        return sale -> new SaleDto(
              sale.getId(),
              sale.getUserId(),
              sale.getProductId(),
              sale.getOrderId()
        );
    }

    public Function<SaleDto, Sale> mapToCollectionSale(){

        return saleDto -> new Sale(
                saleDto.getId(),
                saleDto.getUserId(),
                saleDto.getProductId(),
                saleDto.getOrderId()
        );
    }
}
