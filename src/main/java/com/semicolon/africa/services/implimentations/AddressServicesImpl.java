package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.Address;
import com.semicolon.africa.data.repositories.AddressRepo;
import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.request.FindAddressRequest;
import com.semicolon.africa.dtos.request.UpdateAddressRequest;
import com.semicolon.africa.dtos.response.AddAddressResponse;
import com.semicolon.africa.dtos.response.FindAddressResponse;
import com.semicolon.africa.dtos.response.UpdateAddressResponse;
import com.semicolon.africa.exception.AddressException;
import com.semicolon.africa.services.interfaces.AddressServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.util.Mapper.map;

@Service
public class AddressServicesImpl implements AddressServicesInterface {

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public AddAddressResponse createAddress(AddAddressRequest request) {
        Address address = new Address();
        map(request,address);
        addressRepo.save(address);
        AddAddressResponse addAddressResponse = new AddAddressResponse();
        map(addAddressResponse,address);
        return addAddressResponse;
    }

    @Override
    public FindAddressResponse findById(FindAddressRequest request) {
        Address address = addressRepo.findById(request.getId())
                .orElseThrow(() -> new AddressException("No address found"));
        FindAddressResponse response = new FindAddressResponse();
        map(response,address);
        return response;
    }

    @Override
    public List<FindAddressResponse> findByFirstName(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByMiddleName(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByLastName(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByGender(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByCompany(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByAddress1(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByAddress2(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByCityOrTown(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByCountry(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByState(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByPhoneNumber(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findByEmail(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public UpdateAddressResponse update(UpdateAddressRequest request) {
        return null;
    }
}
