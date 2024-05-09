package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.mappers.UserMapper;
import com.co.linadev.fakestore.application.service.user.interfaces.FillDataUsers;
import com.co.linadev.fakestore.domain.dto.UserDto;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillDataUserUseCase implements FillDataUsers {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> saveAllData(List<UserDto> users) {
        return userRepository.saveAll(users.stream()
                        .map(userMapper.mapToCollectionUser())
                        .collect(Collectors.toList()))
                .map(userMapper.mapToDtoUser());
    }
}
