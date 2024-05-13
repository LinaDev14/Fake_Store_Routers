package com.co.linadev.fakestore.adapters.user.queries;

import com.co.linadev.fakestore.application.service.user.implementations.FindUserByEmailUseCase;
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
public class FindUserByEmailRouter {

    @Bean
    public RouterFunction<ServerResponse> findUserByEmailRouterFunction(FindUserByEmailUseCase findUserByEmailUseCase){
        return route(GET("api/user/{email}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(findUserByEmailUseCase
                                .findByEmailUser(request.pathVariable("email")), UserDto.class)
                        )
        );
    }
}
