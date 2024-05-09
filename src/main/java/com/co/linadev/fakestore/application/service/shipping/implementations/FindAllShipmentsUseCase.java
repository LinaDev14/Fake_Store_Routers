package com.co.linadev.fakestore.application.service.shipping.implementations;

import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.application.service.shipping.interfaces.FindAllShipments;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllShipmentsUseCase implements FindAllShipments {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;


    @Override
    public Flux<ShippingDto> listShipments() {
        return shippingRepository.findAll()
                .map(shippingMapper.mapToDtoShipping());
    }
}
