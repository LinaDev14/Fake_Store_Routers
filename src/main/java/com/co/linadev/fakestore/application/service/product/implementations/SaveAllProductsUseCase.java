package com.co.linadev.fakestore.application.service.product.implementations;


import com.co.linadev.fakestore.application.mappers.ProductMapper;
import com.co.linadev.fakestore.application.service.product.interfaces.SaveAllProducts;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import com.co.linadev.fakestore.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SaveAllProductsUseCase implements SaveAllProducts {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductDto> fillData(List<ProductDto> productDto) {
        return productRepository.saveAll(productDto.stream()
                        .map(productMapper.mapToCollectionProduct())
                        .collect(Collectors.toList()))
                .map(productMapper.mapToDtoProduct());
    }
}
