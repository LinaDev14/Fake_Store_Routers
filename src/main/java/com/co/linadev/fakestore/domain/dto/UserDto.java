package com.co.linadev.fakestore.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String city;
    private String address;
    private String email;
    private String phoneNumber;
}
