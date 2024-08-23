package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.Password;
import com.semicolon.africa.data.repositories.PasswordRepo;
import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.request.DeletePasswordRequest;
import com.semicolon.africa.dtos.request.FindPasswordRequest;
import com.semicolon.africa.dtos.response.AddPasswordResponse;
import com.semicolon.africa.dtos.response.DeletePasswordResponse;
import com.semicolon.africa.dtos.response.FindPasswordResponse;
import com.semicolon.africa.exception.NotFoundException;
import com.semicolon.africa.services.interfaces.PasswordService;
import lombok.AllArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.semicolon.africa.util.Mapper.map;
import static com.semicolon.africa.util.PasswordUtil.decryptPassword;
import static com.semicolon.africa.util.PasswordUtil.encryptPassword;


@Service
@AllArgsConstructor
public class PasswordServiceImpl implements PasswordService {

    private  final PasswordRepo repo;

    @Override
    public AddPasswordResponse createPassword(AddPasswordRequest request) {
        Password password = new Password();
        map(password,request);
        repo.save(password);
        AddPasswordResponse response = new AddPasswordResponse();
        map(password,response);
        return response;
    }


    @Override
    public List<FindPasswordResponse> findPasswordByEmail(FindPasswordRequest request) {
        List<Password> passwords = repo.findByEmail(request.getEmail());
        return listOfPasswordRelated(passwords);
    }

    private List<FindPasswordResponse> listOfPasswordRelated(List<Password> passwords) {
        List<FindPasswordResponse> responses = new ArrayList<>();
        for (Password password : passwords) {
            FindPasswordResponse response = new FindPasswordResponse();
            response.setPassword(decryptPassword(password.getPassword()));
            response.setEmail(password.getEmail());
            response.setUserName(password.getUserName());
            response.setWebsiteLink(password.getWebsiteLink());
            responses.add(response);
        }
        return responses;
    }

    @Override
    public List<FindPasswordResponse> findPasswordByUsername(FindPasswordRequest request) {
        List<Password> passwords = repo.findByUserName(request.getUserName());
        return listOfPasswordRelated(passwords);
    }

    @Override
    public List<FindPasswordResponse> findPassWordByWebLink(FindPasswordRequest request) {
        List<Password> passwords = repo.findByWebsiteLink(request.getWebsiteLink());
        return listOfPasswordRelated(passwords);
    }

    @Override
    public FindPasswordResponse findPasswordById(FindPasswordRequest request) {
        Password password = repo.findById(request.getId())
                .orElseThrow(()->new NotFoundException("Not Found"));
        FindPasswordResponse response = new FindPasswordResponse();
        response.setUserName(password.getEmail());
        response.setPassword(decryptPassword(password.getPassword()));
        response.setEmail(password.getUserName());
        response.setWebsiteLink(password.getWebsiteLink());
        response.setId(password.getId());
        return response;
    }

    @Override
    public DeletePasswordResponse deletePasswordById(DeletePasswordRequest request) {
        FindPasswordRequest request1 = new FindPasswordRequest();
        request1.setId(request.getId());
        FindPasswordResponse response = findPasswordById(request1);
        Password password = new Password();
        map(response,password);
        repo.delete(password);
        DeletePasswordResponse response1 = new DeletePasswordResponse();
        response1.setMessage("Deleted");
        return response1;
    }

    @Override
    public DeletePasswordResponse deletePasswordByWebLink(DeletePasswordRequest request) {
        List<Password> passwords = new ArrayList<>();
        passwords = repo.findByWebsiteLink(request.getWebLink());
        for (Password password : passwords) {
            repo.delete(password);
        }
        DeletePasswordResponse response = new DeletePasswordResponse();
        response.setMessage("Deleted Password");
        return response;
    }


    @Override
    public String generatePassword() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
            .withinRange('0', 'z')
            .filteredBy(Character::isLetterOrDigit)
            .build();

        return generator.generate(9);
    }
}
