package com.co.linadev.fakestore.adapters.product.queries;

import com.co.linadev.fakestore.application.service.product.implementations.FindProductByCategoryUseCase;
import com.co.linadev.fakestore.domain.dto.ProductDto;
import com.co.linadev.fakestore.domain.utils.valueObjects.ProductCategory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindProductByCategory {

    @Bean
    public RouterFunction<ServerResponse> findProductByCategoryRouterFunction(FindProductByCategoryUseCase findProductByCategoryUseCase){
        return route(GET("api/products/category/{category}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findProductByCategoryUseCase
                                .findProductByCategory(ProductCategory.valueOf(request.pathVariable("category"))),
                                ProductDto.class)
                        )
        );
    }
}
