package com.co.linadev.fakestore.application.service.shipping.implementations;

import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.application.service.shipping.interfaces.FillDataShipments;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillDataShipmentsUseCase implements FillDataShipments {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;


    @Override
    public Flux<ShippingDto> fillDataShipments(List<ShippingDto> shippingDto) {
        return shippingRepository.saveAll(shippingDto.stream()
                        .map(shippingMapper.mapToCollectionShipping())
                        .collect(Collectors.toList()))
                .map(shippingMapper.mapToDtoShipping());
    }
}
