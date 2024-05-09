package com.co.linadev.fakestore.application.service.user.interfaces;

import com.co.linadev.fakestore.domain.dto.UserDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface FillDataUsers {

    Flux<UserDto> saveAllData(List<UserDto> users);
}
