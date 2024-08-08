package com.semicolon.africa.data.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Address {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName	;
    private String gender;
    private String birthday;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipPostalCode;
    private String country;
    private String phone;
    private String email;
}
