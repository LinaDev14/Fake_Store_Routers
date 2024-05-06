package com.co.linadev.fakestore.application.usecases.consultant.implementations;

import com.co.linadev.fakestore.application.mappers.ConsultantMapper;
import com.co.linadev.fakestore.application.usecases.consultant.interfaces.FindAllConsultants;
import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import com.co.linadev.fakestore.domain.repository.ConsultantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class FindAllConsultantsUseCase implements FindAllConsultants {

    private final ConsultantRepository consultantRepository;
    private final ConsultantMapper consultantMapper;

    @Override
    public Flux<ConsultantDto> listConsultants() {
        return consultantRepository.findAll()
                .map(consultantMapper.mapToDtoConsultant());
    }
}
