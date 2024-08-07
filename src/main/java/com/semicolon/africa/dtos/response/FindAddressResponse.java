package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindAddressResponse {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName	;
    private String gender;
    private String birthday;
    private String company;
    private String address1;
    private String address2;
    private String cityOrTown;
    private String state;
    private String zipPostalCode;
    private String country;
    private String phone;
    private String email;
    private String message;
}
