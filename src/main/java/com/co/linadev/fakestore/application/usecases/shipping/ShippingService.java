package com.co.linadev.fakestore.application.usecases.shipping;

import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import com.co.linadev.fakestore.domain.utils.messages.ShippingMessage;
import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import com.co.linadev.fakestore.domain.utils.valueObjects.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShippingService implements ShippingServiceInterface{

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;

    @Override
    public Mono<ShippingDto> saveShipping(ShippingDto shippingDto) {
        return shippingRepository.save(shippingMapper.mapToCollectionShipping()
                .apply(shippingDto))
                .map(shippingMapper.mapToDtoShipping());
    }

    @Override
    public Flux<ShippingDto> fillDataShipments(List<ShippingDto> shippingDto) {
        return shippingRepository.saveAll(shippingDto.stream()
                .map(shippingMapper.mapToCollectionShipping())
                .collect(Collectors.toList()))
                .map(shippingMapper.mapToDtoShipping());
    }

    @Override
    public Flux<ShippingDto> listShipments() {
        return shippingRepository.findAll()
                .map(shippingMapper.mapToDtoShipping());
    }

    @Override
    public Mono<ShippingDto> updateShipping(ShippingDto shippingDto) {
        Objects.requireNonNull(shippingDto.getId(), ShippingMessage.REQUIRED_ID);

        return shippingRepository.save(shippingMapper.mapToCollectionShipping()
                .apply(shippingDto))
                .map(shippingMapper.mapToDtoShipping());
    }


    @Override
    public Flux<ShippingDto> findShipmentsByStatus(Status status) {
        return shippingRepository.findShipmentsByStatus(status)
                .map(shippingMapper.mapToDtoShipping());
    }

    @Override
    public Flux<ShippingDto> findShipmentsByCompany(ShippingCompany shippingCompany) {
        return shippingRepository.findShipmentsByCompany(shippingCompany)
                .map(shippingMapper.mapToDtoShipping());
    }

    @Override
    public Mono<ShippingDto> findByShippingId(String id) {
        return shippingRepository.findById(id)
                .map(shippingMapper.mapToDtoShipping())
                .switchIfEmpty(Mono.error(new RuntimeException(ShippingMessage.SHIPPING_NOT_FOUND)));
    }

    @Override
    public Mono<ShippingDto> findShippingByOrderId(String orderId) {
        return shippingRepository.findShippingByOrderId(orderId)
                .map(shippingMapper.mapToDtoShipping());
    }

}
