package com.co.linadev.fakestore.application.service.user.interfaces;

import com.co.linadev.fakestore.domain.dto.UserDto;
import reactor.core.publisher.Flux;

public interface FindAllUsers {

    Flux<UserDto> listUsers();
}
