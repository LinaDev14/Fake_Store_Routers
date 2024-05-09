package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.mappers.UserMapper;
import com.co.linadev.fakestore.application.service.user.interfaces.FindUserByEmail;
import com.co.linadev.fakestore.domain.dto.UserDto;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindUserByEmailUseCase implements FindUserByEmail {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<UserDto> findByEmailUser(String email) {
        return userRepository.findUserByEmail(email)
                .map(userMapper.mapToDtoUser());
    }
}
