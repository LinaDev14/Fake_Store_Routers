package com.co.linadev.fakestore.application.usecases.consultant.implementations;

import com.co.linadev.fakestore.application.mappers.ConsultantMapper;
import com.co.linadev.fakestore.application.usecases.consultant.interfaces.SaveAllConsultants;
import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import com.co.linadev.fakestore.domain.repository.ConsultantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class SaveAllConsultantsUseCase implements SaveAllConsultants {

    private final ConsultantRepository consultantRepository;
    private final ConsultantMapper consultantMapper;


    @Override
    public Flux<ConsultantDto> saveAllData(List<ConsultantDto> consultantDto) {
        return consultantRepository.saveAll(consultantDto.stream()
                        .map(consultantMapper.mapToCollectionConsultant())
                        .collect(Collectors.toList()))
                .map(consultantMapper.mapToDtoConsultant());
    }
}
