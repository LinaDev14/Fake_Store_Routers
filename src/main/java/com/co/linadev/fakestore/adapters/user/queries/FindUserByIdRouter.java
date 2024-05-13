package com.co.linadev.fakestore.adapters.user.queries;

import com.co.linadev.fakestore.application.service.user.implementations.FindUserByIdUseCase;
import com.co.linadev.fakestore.domain.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class FindUserByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> findUserByIdRouterFunction(FindUserByIdUseCase findUserByIdUseCase){
        return route(GET("api/user/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findUserByIdUseCase
                                    .findUserById(request.pathVariable("id")), UserDto.class)
                        )
        );
    }
}
