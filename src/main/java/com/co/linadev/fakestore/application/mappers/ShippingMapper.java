package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Shipping;
import com.co.linadev.fakestore.domain.dto.ShippingDto;

import java.util.function.Function;

public class ShippingMapper {

    public Function<Shipping, ShippingDto> mapToDtoShipping(){

        return shipping -> new ShippingDto(
               shipping.getId(),
               shipping.getOrderId(),
               shipping.getShippingCompany(),
               shipping.getStatus(),
               shipping.getShappingDate(),
               shipping.getEstimatedDeliveryDate()
        );
    }

    public Function<ShippingDto, Shipping> mapToCollectionShipping(){

        return shippingDto -> new Shipping(
                shippingDto.getId(),
                shippingDto.getOrderId(),
                shippingDto.getShippingCompany(),
                shippingDto.getStatus(),
                shippingDto.getShappingDate(),
                shippingDto.getEstimatedDeliveryDate()
        );
    }
}
