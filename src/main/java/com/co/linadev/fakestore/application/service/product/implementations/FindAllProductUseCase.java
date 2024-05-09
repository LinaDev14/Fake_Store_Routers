package com.co.linadev.fakestore.application.service.product.implementations;


import com.co.linadev.fakestore.application.mappers.ProductMapper;
import com.co.linadev.fakestore.application.service.product.interfaces.FindAllProducts;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import com.co.linadev.fakestore.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindAllProductUseCase implements FindAllProducts {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductDto> listProduct() {
        return productRepository.findAll()
                .map(productMapper.mapToDtoProduct());
    }
}
