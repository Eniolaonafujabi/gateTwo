package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends MongoRepository<Address, String> {
}
