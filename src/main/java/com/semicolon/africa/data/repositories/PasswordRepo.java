package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Password;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PasswordRepo extends MongoRepository<Password, String> {
    List<Password> findByEmail(String email);

    List<Password> findByUserName(String userName);

    List<Password> findByWebsiteLink(String webLink);

}
