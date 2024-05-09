package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.mappers.UserMapper;
import com.co.linadev.fakestore.application.service.user.interfaces.CreateUser;
import com.co.linadev.fakestore.domain.dto.UserDto;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase implements CreateUser {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<UserDto> saveUser(UserDto userDto) {
        return userRepository.save(userMapper.mapToCollectionUser()
                        .apply(userDto))
                .map(userMapper.mapToDtoUser());

    }
}
