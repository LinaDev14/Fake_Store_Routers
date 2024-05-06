package com.co.linadev.fakestore.application.usecases.user;


import com.co.linadev.fakestore.domain.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserServiceInterface {

    // list user
    Flux<UserDto> listUsers();

    // find by id
    Mono<UserDto> findByUserId(String id);

    // save user
    Mono<UserDto> saveUser(UserDto userDto);

    // save all data
    Flux<UserDto> saveAllData(List<UserDto> users);

    // update user
    Mono<UserDto> updateUser(UserDto userDto);

    // delete user
    Mono<String> deleteById(String id);

    // delete all users
    Mono<String> deleteAll();

    // find by email
    Mono<UserDto> findByEmailUser(String email);


}
