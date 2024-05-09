package com.co.linadev.fakestore.application.service.user.implementations;

import com.co.linadev.fakestore.application.service.user.interfaces.DeleteUserById;
import com.co.linadev.fakestore.domain.repository.UserRepository;
import com.co.linadev.fakestore.domain.utils.messages.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteUserByIdUseCase implements DeleteUserById {

    private final UserRepository userRepository;

    @Override
    public Mono<String> deleteById(String id) {
        return userRepository.deleteById(id)
                .flatMap(user -> userRepository.deleteById(id)
                        .then(Mono.just(UserMessage.USER_DELETE)));
    }
}
