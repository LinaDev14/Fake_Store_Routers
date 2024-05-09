package com.co.linadev.fakestore.application.service.product.implementations;

import com.co.linadev.fakestore.application.mappers.ProductMapper;
import com.co.linadev.fakestore.application.service.product.interfaces.FindAllProductsByName;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import com.co.linadev.fakestore.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindAllProductsByNameUseCase implements FindAllProductsByName {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductDto> findAllByProductName(String productName) {
        return productRepository.findAllByProductIgnoreCase(productName)
                .map(productMapper.mapToDtoProduct());
    }
}
