package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.Address;
import com.semicolon.africa.data.repositories.AddressRepo;
import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.request.DeleteAddressRequest;
import com.semicolon.africa.dtos.request.FindAddressRequest;
import com.semicolon.africa.dtos.response.AddAddressResponse;
import com.semicolon.africa.dtos.response.DeleteAddressResponse;
import com.semicolon.africa.dtos.response.FindAddressResponse;
import com.semicolon.africa.exception.AddressException;
import com.semicolon.africa.services.interfaces.AddressServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.semicolon.africa.util.Mapper.map;

@Service
public class AddressServicesImpl implements AddressServices {

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
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByFirstName(request.getFirstName());
        return arrangeResponses(responses, addresses);
    }

    private List<FindAddressResponse> arrangeResponses(List<FindAddressResponse> responses, List<Address> addresses) {
        for (Address address : addresses) {
            FindAddressResponse response = new FindAddressResponse();
            map(response,address);
            responses.add(response);
        }
        return responses;
    }


    @Override
    public List<FindAddressResponse> findByMiddleName(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByMiddleName(request.getMiddleName());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByLastName(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByLastName(request.getLastName());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByGender(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByGender(request.getGender());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByCompany(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByCompany(request.getCompany());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByAddress1(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByAddress1(request.getAddress1());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByAddress2(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByAddress2(request.getAddress2());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByCityOrTown(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByCity(request.getCityOrTown());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByCountry(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByCountry(request.getCountry());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByState(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByState(request.getState());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByPhoneNumber(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByPhone(request.getPhone());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public List<FindAddressResponse> findByEmail(FindAddressRequest request) {
        List<FindAddressResponse> responses = new ArrayList<>();
        List<Address> addresses = addressRepo.findByEmail(request.getEmail());
        return arrangeResponses(responses,addresses);
    }

    @Override
    public DeleteAddressResponse delete(DeleteAddressRequest addressRequest) {
        Address address = addressRepo.findById(addressRequest.getId())
                .orElseThrow(() -> new AddressException("No address found"));
        addressRepo.delete(address);
        DeleteAddressResponse response = new DeleteAddressResponse();
        response.setMessage("Successfully deleted address");
        return response;
    }


}
