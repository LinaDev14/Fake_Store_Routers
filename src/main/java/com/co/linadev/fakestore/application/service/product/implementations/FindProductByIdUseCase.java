package com.co.linadev.fakestore.application.service.product.implementations;


import com.co.linadev.fakestore.application.mappers.ProductMapper;
import com.co.linadev.fakestore.application.service.product.interfaces.FindProductById;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import com.co.linadev.fakestore.domain.repository.ProductRepository;
import com.co.linadev.fakestore.domain.utils.messages.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class FindProductByIdUseCase implements FindProductById {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Mono<ProductDto> findById(String id) {
        return productRepository.findById(id)
                .map(productMapper.mapToDtoProduct())
                .switchIfEmpty(Mono.error(new RuntimeException(UserMessage.USER_NOT_FOUND)));
    }
}
