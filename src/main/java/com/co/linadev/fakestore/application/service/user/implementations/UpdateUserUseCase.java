package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.mappers.UserMapper;
import com.co.linadev.fakestore.application.service.user.interfaces.UpdateUser;
import com.co.linadev.fakestore.domain.dto.UserDto;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import com.co.linadev.fakestore.domain.utils.messages.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCase implements UpdateUser {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<UserDto> updateUser(UserDto userDto) {
        Objects.requireNonNull(userDto.getId(), UserMessage.REQUIRED);

        return userRepository.save(userMapper.mapToCollectionUser()
                        .apply(userDto))
                .map(userMapper.mapToDtoUser());
    }
}
