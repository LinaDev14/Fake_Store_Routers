package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.mappers.UserMapper;
import com.co.linadev.fakestore.application.service.user.interfaces.FindUserById;
import com.co.linadev.fakestore.domain.dto.UserDto;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import com.co.linadev.fakestore.domain.utils.messages.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindUserByIdUseCase implements FindUserById {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<UserDto> findByUserId(String id) {
        return userRepository.findById(id)
                .map(userMapper.mapToDtoUser())
                .switchIfEmpty(Mono.error(new RuntimeException(UserMessage.USER_NOT_FOUND)));
    }
}
