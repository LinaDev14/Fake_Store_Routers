package com.co.linadev.fakestore.application.service.shipping.implementations;

import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.application.service.shipping.interfaces.FindShipmentsByStatus;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindShipmentsByStatusUseCase implements FindShipmentsByStatus {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;

    @Override
    public Flux<ShippingDto> findShipmentsByStatus(Status status) {
        return shippingRepository.findShipmentsByStatus(status)
                .map(shippingMapper.mapToDtoShipping());
    }
}
