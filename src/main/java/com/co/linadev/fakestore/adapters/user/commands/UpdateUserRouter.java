package com.co.linadev.fakestore.adapters.user.commands;

import com.co.linadev.fakestore.application.service.user.implementations.UpdateUserUseCase;
import com.co.linadev.fakestore.domain.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateUserRouter {

    @Bean
    public RouterFunction<ServerResponse> updateUserRouterFunction(UpdateUserUseCase updateUserUseCase){

        return route(PUT("/api/update-user")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(UserDto.class)
                        .flatMap(updateUserUseCase::updateUser)
                        .flatMap(result -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(result)
                        )
        );
    }

}
