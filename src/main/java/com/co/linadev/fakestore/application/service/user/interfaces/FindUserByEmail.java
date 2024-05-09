package com.co.linadev.fakestore.application.service.user.interfaces;

import com.co.linadev.fakestore.domain.dto.UserDto;
import reactor.core.publisher.Mono;


public interface FindUserByEmail {

    Mono<UserDto> findByEmailUser(String email);
}
