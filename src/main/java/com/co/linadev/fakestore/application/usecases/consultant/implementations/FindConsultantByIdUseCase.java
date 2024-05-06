package com.co.linadev.fakestore.application.usecases.consultant.implementations;

import com.co.linadev.fakestore.application.mappers.ConsultantMapper;
import com.co.linadev.fakestore.application.usecases.consultant.interfaces.FindConsultantById;
import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import com.co.linadev.fakestore.domain.repository.ConsultantRepository;
import com.co.linadev.fakestore.domain.utils.messages.ConsultantMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class FindConsultantByIdUseCase  implements FindConsultantById {

    private final ConsultantRepository consultantRepository;
    private final ConsultantMapper consultantMapper;


    @Override
    public Mono<ConsultantDto> findConsultantById(String id) {
        return consultantRepository.findById(id)
                .map(consultantMapper.mapToDtoConsultant())
                .switchIfEmpty(Mono.error(new RuntimeException(ConsultantMessage.CONSULTANT_NOT_FOUND)));

    }
}
