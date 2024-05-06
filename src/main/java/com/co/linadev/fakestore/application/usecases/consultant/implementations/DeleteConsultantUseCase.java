package com.co.linadev.fakestore.application.usecases.consultant.implementations;

import com.co.linadev.fakestore.application.mappers.ConsultantMapper;
import com.co.linadev.fakestore.application.usecases.consultant.interfaces.DeleteConsultant;
import com.co.linadev.fakestore.domain.repository.ConsultantRepository;
import com.co.linadev.fakestore.domain.utils.messages.ConsultantMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class DeleteConsultantUseCase implements DeleteConsultant {

    private final ConsultantRepository consultantRepository;
    private final ConsultantMapper consultantMapper;

    @Override
    public Mono<String> deleteConsultant(String id) {
        return consultantRepository.findById(id)
                .flatMap(consultant -> consultantRepository.deleteById(id))
                .then(Mono.just(ConsultantMessage.CONSULTANT_DELETE));
    }
}
