package com.co.linadev.fakestore.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "Users")
public class User {

    @Id
    private final String id;

    private final String firstName;
    private final String lastname;
    private final String password;
    private final String city;
    private final String address;
    private final String email;
    private final String phoneNumber;
}
