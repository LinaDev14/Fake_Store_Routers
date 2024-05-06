package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.User;
import com.co.linadev.fakestore.domain.dto.UserDto;

import java.util.function.Function;

public class UserMapper {

    public Function<User, UserDto> mapToDtoUser(){

        return user -> new UserDto(
              user.getId(),
              user.getUserName(),
              user.getPassword(),
              user.getCity(),
              user.getAddress(),
              user.getEmail(),
              user.getPhoneNumber()
        );
    }

    public Function<UserDto, User> mapToCollectionUser(){

        return userDto -> new User(
                userDto.getId(),
                userDto.getUserName(),
                userDto.getPassword(),
                userDto.getCity(),
                userDto.getAddress(),
                userDto.getEmail(),
                userDto.getPhoneNumber()
        );
    }
}
