package com.co.linadev.fakestore.application.service.shipping.implementations;

import com.co.linadev.fakestore.application.mappers.ShippingMapper;
import com.co.linadev.fakestore.application.service.shipping.interfaces.UpdateShipping;
import com.co.linadev.fakestore.domain.dto.ShippingDto;
import com.co.linadev.fakestore.domain.repository.ShippingRepository;
import com.co.linadev.fakestore.domain.utils.messages.ShippingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UpdateShippingUseCase implements UpdateShipping {

    private final ShippingRepository shippingRepository;
    private final ShippingMapper shippingMapper;

    @Override
    public Mono<ShippingDto> updateShipping(ShippingDto shippingDto) {
        Objects.requireNonNull(shippingDto.getId(), ShippingMessage.REQUIRED_ID);

        return shippingRepository.save(shippingMapper.mapToCollectionShipping()
                        .apply(shippingDto))
                .map(shippingMapper.mapToDtoShipping());
    }
}
