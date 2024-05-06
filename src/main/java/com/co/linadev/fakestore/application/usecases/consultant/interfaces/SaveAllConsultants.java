package com.co.linadev.fakestore.application.usecases.consultant.interfaces;

import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface SaveAllConsultants {

    Flux<ConsultantDto> saveAllData(List<ConsultantDto> consultantDto);
}
