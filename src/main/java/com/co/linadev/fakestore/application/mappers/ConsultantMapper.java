package com.co.linadev.fakestore.application.mappers;

import com.co.linadev.fakestore.domain.collections.Consultant;
import com.co.linadev.fakestore.domain.dto.ConsultantDto;

import java.util.function.Function;

public class ConsultantMapper {

    public Function<Consultant, ConsultantDto> mapToDtoConsultant(){

        return consultant -> new ConsultantDto(
                consultant.getId(),
                consultant.getFirstName(),
                consultant.getLastName(),
                consultant.getEmail()
        );
    }

    public Function<ConsultantDto, Consultant> mapToCollectionConsultant(){

        return consultantDto -> new Consultant(
                consultantDto.getId(),
                consultantDto.getFirstName(),
                consultantDto.getLastName(),
                consultantDto.getEmail()
        );
    }


}
