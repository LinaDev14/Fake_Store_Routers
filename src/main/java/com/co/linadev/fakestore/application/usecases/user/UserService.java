package com.co.linadev.fakestore.application.usecases.user;

import com.co.linadev.fakestore.application.mappers.UserMapper;
import com.co.linadev.fakestore.domain.dto.UserDto;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import com.co.linadev.fakestore.domain.utils.messages.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService  implements UserServiceInterface{

    // Repository
    private final UserRepository userRepository;

    // Mapper
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> listUsers() {
        return userRepository.findAll()
                .map(userMapper.mapToDtoUser());
    }

    @Override
    public Mono<UserDto> findByUserId(String id) {
        return userRepository.findById(id)
                .map(userMapper.mapToDtoUser())
                .switchIfEmpty(Mono.error(new RuntimeException(UserMessage.USER_NOT_FOUND)));
    }

    @Override
    public Mono<UserDto> saveUser(UserDto userDto) {
        return userRepository.save(userMapper.mapToCollectionUser()
                .apply(userDto))
                .map(userMapper.mapToDtoUser());
    }

    @Override
    public Flux<UserDto> saveAllData(List<UserDto> users) {
        return userRepository.saveAll(users.stream()
                .map(userMapper.mapToCollectionUser())
                .collect(Collectors.toList()))
                .map(userMapper.mapToDtoUser());
    }

    @Override
    public Mono<UserDto> updateUser(UserDto userDto) {
        Objects.requireNonNull(userDto.getId(), UserMessage.REQUIRED);

        return userRepository.save(userMapper.mapToCollectionUser()
                .apply(userDto))
                .map(userMapper.mapToDtoUser());
    }

    @Override
    public Mono<String> deleteById(String id) {
        return userRepository.deleteById(id)
                .flatMap(user -> userRepository.deleteById(id)
                .then(Mono.just(UserMessage.USER_DELETE)));
    }

    @Override
    public Mono<String> deleteAll() {
        return userRepository.deleteAll()
                .flatMap(user -> userRepository.deleteAll()
                        .then(Mono.just(UserMessage.USERS_DELETED)));

    }

    @Override
    public Mono<UserDto> findByEmailUser(String email) {
        return userRepository.findByEmailUser(email)
                .map(userMapper.mapToDtoUser());
    }
}
