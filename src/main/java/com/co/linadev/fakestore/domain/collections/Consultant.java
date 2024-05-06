package com.co.linadev.fakestore.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "consultants")
public class Consultant {

    @Id
    private final String id;

    private final String firstName;
    private final String lastName;
    private final String email;
}
