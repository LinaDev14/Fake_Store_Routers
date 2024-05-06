package com.co.linadev.fakestore.application.usecases.consultant.implementations;

import com.co.linadev.fakestore.application.mappers.ConsultantMapper;
import com.co.linadev.fakestore.application.usecases.consultant.interfaces.CreateConsultant;
import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import com.co.linadev.fakestore.domain.repository.ConsultantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CreateConsultantUseCase implements CreateConsultant {

    private final ConsultantRepository consultantRepository;
    private final ConsultantMapper consultantMapper;


    @Override
    public Mono<ConsultantDto> createConsultant(ConsultantDto consultantDto) {
        return consultantRepository.save(consultantMapper.mapToCollectionConsultant()
                        .apply(consultantDto))
                .map(consultantMapper.mapToDtoConsultant());
    }
}
