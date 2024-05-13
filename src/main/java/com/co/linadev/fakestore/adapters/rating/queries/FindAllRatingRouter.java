package com.co.linadev.fakestore.adapters.rating.queries;

import com.co.linadev.fakestore.application.service.rating.implementations.FindAllRatingsUseCase;
import com.co.linadev.fakestore.domain.dto.RatingDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindAllRatingRouter {

    @Bean
    public RouterFunction<ServerResponse> findAllRatingsRouterFunction(FindAllRatingsUseCase findAllRatingsUseCase){
        return route(
                GET("/api/ratings"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findAllRatingsUseCase.findAllRatings(), RatingDto.class)));
    }
}
