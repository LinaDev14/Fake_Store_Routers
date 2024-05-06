package com.co.linadev.fakestore.application.usecases.product;

import com.co.linadev.fakestore.adapters.webclient.WebClientAdapter;
import com.co.linadev.fakestore.application.mappers.ApiProductMapper;
import com.co.linadev.fakestore.application.mappers.ProductMapper;
import com.co.linadev.fakestore.domain.collections.Product;
import com.co.linadev.fakestore.domain.dto.ApiProductDto;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import com.co.linadev.fakestore.domain.repository.ProductRepository;
import com.co.linadev.fakestore.domain.utils.messages.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final WebClientAdapter webClientAdapter;
    private final ApiProductMapper apiProductMapper;

    @Override
    public Flux<ProductDto> listProduct() {
        return productRepository.findAll()
                .map(productMapper.mapToDtoProduct());
    }

    @Override
    public Mono<ProductDto> findById(String id) {
        return productRepository.findById(id)
                .map(productMapper.mapToDtoProduct())
                .switchIfEmpty(Mono.error(new RuntimeException(UserMessage.USER_NOT_FOUND)));
    }

    @Override
    public Flux<ProductDto> fillData(List<ProductDto> productDto) {
        return productRepository.saveAll(productDto.stream()
                .map(productMapper.mapToCollectionProduct())
                .collect(Collectors.toList()))
                .map(productMapper.mapToDtoProduct());
    }

    @Override
    public Mono<ProductDto> saveProduct(ProductDto productDto) {
        return productRepository.save(productMapper.mapToCollectionProduct()
                .apply(productDto))
                .map(productMapper.mapToDtoProduct());
    }

    @Override
    public Flux<ProductDto> findAllByProductName(String productName) {
        return productRepository.findAllByProductNameIgnoreCase(productName)
                .map(productMapper.mapToDtoProduct());
    }

    @Override
    public Flux<ProductDto> findAllByPriceLessThan(Double productPrice) {
        return productRepository.findAllByPriceLessThan(productPrice)
                .map(productMapper.mapToDtoProduct());
    }

    @Override
    public Flux<ProductDto> findAllByPriceGreaterThan(Double productPrice) {
        return productRepository.findAllByPriceGreaterThan(productPrice)
                .map(productMapper.mapToDtoProduct());
    }

    @Override
    public Flux<ProductDto> findAllByPrice(Double productPrice) {
        return productRepository.findAllByPrice(productPrice)
                .map(productMapper.mapToDtoProduct());
    }

    @Override
    public Flux<ProductDto> fetchData() {

            Flux<ApiProductDto> apiProductDtoFlux = webClientAdapter.retrieveAllProducts();

            Flux<Product> products = apiProductDtoFlux
                    .map(apiProductMapper.mapToDTOApiProduct());

            return productRepository.saveAll(products)
                    .map(productMapper.mapToDtoProduct());
    }

}
