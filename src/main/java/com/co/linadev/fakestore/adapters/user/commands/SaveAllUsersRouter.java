package com.co.linadev.fakestore.adapters.user.commands;

import com.co.linadev.fakestore.application.service.user.implementations.FillDataUserUseCase;
import com.co.linadev.fakestore.domain.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SaveAllUsersRouter {

    @Bean
    public RouterFunction<ServerResponse> saveAllUsersRouterFunction(FillDataUserUseCase fillDataUserUseCase){
        return route(
                POST("/api/save-all-users")
                        .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(new ParameterizedTypeReference<List<UserDto>>() {})
                        .flatMapMany(fillDataUserUseCase::saveAllData)
                        .collect(Collectors.toList())
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))

        );
    }
}
