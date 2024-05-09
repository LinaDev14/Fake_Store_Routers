package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.mappers.UserMapper;
import com.co.linadev.fakestore.application.service.user.interfaces.FindAllUsers;
import com.co.linadev.fakestore.domain.dto.UserDto;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllUserUseCase implements FindAllUsers {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> listUsers() {
        return userRepository.findAll()
                .map(userMapper.mapToDtoUser());
    }
}
