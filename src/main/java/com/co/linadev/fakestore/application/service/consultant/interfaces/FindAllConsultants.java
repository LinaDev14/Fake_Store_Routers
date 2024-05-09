package com.co.linadev.fakestore.application.service.consultant.interfaces;

import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import reactor.core.publisher.Flux;

public interface FindAllConsultants {

    Flux<ConsultantDto> listConsultants();
}
