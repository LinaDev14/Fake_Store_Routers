package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.service.user.interfaces.DeleteAllUsers;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import com.co.linadev.fakestore.domain.utils.messages.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor

public class DeleteAllUserUseCase implements DeleteAllUsers {

    private final UserRepository userRepository;


    @Override
    public Mono<String> deleteAll() {
        return userRepository.deleteAll()
                .flatMap(user -> userRepository.deleteAll()
                        .then(Mono.just(UserMessage.USERS_DELETED)));
    }
}
