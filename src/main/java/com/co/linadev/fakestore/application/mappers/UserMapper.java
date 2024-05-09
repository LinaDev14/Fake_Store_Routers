package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.User;
import com.co.linadev.fakestore.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class UserMapper {

    public Function<User, UserDto> mapToDtoUser(){

        return user -> new UserDto(
              user.getId(),
              user.getFirstName(),
              user.getLastname(),
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
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getPassword(),
                userDto.getCity(),
                userDto.getAddress(),
                userDto.getEmail(),
                userDto.getPhoneNumber()
        );
    }
}
