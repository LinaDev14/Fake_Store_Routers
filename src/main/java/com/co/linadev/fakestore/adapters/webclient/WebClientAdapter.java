package com.co.linadev.fakestore.adapters.webclient;

import com.co.linadev.fakestore.domain.dto.ApiProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class WebClientAdapter {


    private static final String baseURL = "https://fakestoreapi.com/products";
    private final WebClient webClient = WebClient.create(baseURL);

    public Flux<ApiProductDto> retrieveAllProducts(){

        return webClient.get()
                .uri("https://fakestoreapi.com/products")
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<ApiProductDto>() {});
    }
}
