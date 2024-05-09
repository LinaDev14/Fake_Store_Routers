package com.co.linadev.fakestore.application.service.product.implementations;

import com.co.linadev.fakestore.application.mappers.ProductMapper;
import com.co.linadev.fakestore.application.service.product.interfaces.CreateProduct;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import com.co.linadev.fakestore.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreateProductUseCase implements CreateProduct {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Mono<ProductDto> saveProduct(ProductDto productDto) {
        return productRepository.save(productMapper.mapToCollectionProduct()
                        .apply(productDto))
                .map(productMapper.mapToDtoProduct());
    }
}
