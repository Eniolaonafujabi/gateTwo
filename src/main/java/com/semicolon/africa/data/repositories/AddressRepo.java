package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends MongoRepository<Address, String> {
    List<Address> findByFirstName(String firstName);

    List<Address> findByMiddleName(String middleName);

    List<Address> findByLastName(String lastName);

    List<Address> findByGender(String gender);

    List<Address> findByCompany(String company);

    List<Address> findByAddress1(String address1);

    List<Address> findByAddress2(String address2);

    List<Address> findByCity(String city);

    List<Address> findByCountry(String country);

    List<Address> findByState(String state);

    List<Address> findByPhone(String phoneNumber);

    List<Address> findByEmail(String email);
}
