package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Password;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PasswordRepo extends MongoRepository<Password, String> {
    List<Password> findByEmail(String email);

    List<Password> findByUserName(String userName);

    List<Password> findByWebsiteLink(String webLink);

}
