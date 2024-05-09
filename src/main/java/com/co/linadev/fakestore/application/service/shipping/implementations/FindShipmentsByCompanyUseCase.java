package com.co.linadev.fakestore.application.service.shipping.implementations;


import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.application.service.shipping.interfaces.FindShipmentsByCompany;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import com.co.linadev.fakestore.domain.utils.valueObjects.ShippingCompany;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindShipmentsByCompanyUseCase implements FindShipmentsByCompany {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;

    @Override
    public Flux<ShippingDto> findShipmentsByCompany(ShippingCompany shippingCompany) {
        return shippingRepository.findShipmentsByShippingCompany(shippingCompany)
                .map(shippingMapper.mapToDtoShipping());
    }
}
