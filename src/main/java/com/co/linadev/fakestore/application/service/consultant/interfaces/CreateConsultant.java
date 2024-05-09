package com.co.linadev.fakestore.application.service.consultant.interfaces;

import com.co.linadev.fakestore.domain.dto.ConsultantDto;
import reactor.core.publisher.Mono;

public interface CreateConsultant {

    Mono<ConsultantDto> createConsultant(ConsultantDto consultantDto);
}
