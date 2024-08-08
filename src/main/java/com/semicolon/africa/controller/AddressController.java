package com.semicolon.africa.controller;

import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.request.DeleteAddressRequest;
import com.semicolon.africa.dtos.request.DeletePasswordRequest;
import com.semicolon.africa.dtos.request.FindAddressRequest;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.services.implimentations.AddressServicesImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping
public class AddressController {
    private final AddressServicesImpl addressServices;

    public AddressController(AddressServicesImpl addressServices) {
        this.addressServices = addressServices;
    }

    @PostMapping("create/Address")
    public ResponseEntity<?> addAddress(@RequestBody AddAddressRequest request) {
        try {
            AddAddressResponse response = addressServices.createAddress(request);
            return new ResponseEntity<>(new ApiResponse(true,response),CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressById/{id}")
    public ResponseEntity<?> findNoteById(@PathVariable("id") String id) {
        FindAddressRequest request = new FindAddressRequest();
        request.setId(id);
        try {
            FindAddressResponse response = addressServices.findById(request);
            return new ResponseEntity<>(new ApiResponse(true,response),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByFirstName/{firstName}")
    public ResponseEntity<?> findAddressByFirstName(@PathVariable("firstName") String firstName) {
        FindAddressRequest request = new FindAddressRequest();
        request.setFirstName(firstName);
        try {
            List<FindAddressResponse> responses = addressServices.findByFirstName(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByMiddleName/{middleName}")
    public ResponseEntity<?> findAddressByMiddleName(@PathVariable("middleName") String middleName) {
        FindAddressRequest request = new FindAddressRequest();
        request.setMiddleName(middleName);
        try {
            List<FindAddressResponse> responses = addressServices.findByMiddleName(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByLast/{lastName}")
    public ResponseEntity<?> findAddressByLastName(@PathVariable("lastName") String lastName) {
        FindAddressRequest request = new FindAddressRequest();
        request.setLastName(lastName);
        try {
            List<FindAddressResponse> responses = addressServices.findByLastName(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByGender/{gender}")
    public ResponseEntity<?> findAddressByGenderName(@PathVariable("gender") String gender) {
        FindAddressRequest request = new FindAddressRequest();
        request.setGender(gender);
        try {
            List<FindAddressResponse> responses = addressServices.findByGender(  request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByCompany/{company}")
    public ResponseEntity<?> findAddressByCompany(@PathVariable("company") String company) {
        FindAddressRequest request = new FindAddressRequest();
        request.setCompany(company);
        try {
            List<FindAddressResponse> responses = addressServices.findByCompany(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByAddress/{address1}")
    public ResponseEntity<?> findAddressByAddress(@PathVariable("address1") String address1) {
        FindAddressRequest request = new FindAddressRequest();
        request.setAddress1(address1);
        try {
            List<FindAddressResponse> responses = addressServices.findByAddress1(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByAddress/{address2}")
    public ResponseEntity<?> findAddressByAddress2(@PathVariable("address2") String address2) {
        FindAddressRequest request = new FindAddressRequest();
        request.setAddress1(address2);
        try {
            List<FindAddressResponse> responses = addressServices.findByAddress2(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByCityOrTown/{city}")
    public ResponseEntity<?> findAddressByCity(@PathVariable("city") String city) {
        FindAddressRequest request = new FindAddressRequest();
        request.setCityOrTown(city);
        try {
            List<FindAddressResponse> responses = addressServices.findByCityOrTown(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByCountry/{country}")
    public ResponseEntity<?> findAddressByCountry(@PathVariable("country") String country) {
        FindAddressRequest request = new FindAddressRequest();
        request.setCityOrTown(country);
        try {
            List<FindAddressResponse> responses = addressServices.findByCountry(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByState/{state}")
    public ResponseEntity<?> findAddressByState(@PathVariable("state") String state) {
        FindAddressRequest request = new FindAddressRequest();
        request.setState(state);
        try {
            List<FindAddressResponse> responses = addressServices.findByState(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findAddressByPhoneNumber/{phoneNumber}")
    public ResponseEntity<?> findAddressByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) {
        FindAddressRequest request = new FindAddressRequest();
        request.setState(phoneNumber);
        try {
            List<FindAddressResponse> responses = addressServices.findByState(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }
    @GetMapping("findAddressByPhoneNumber/{email}")
    public ResponseEntity<?> findAddressByEmail(@PathVariable("email") String email) {
        FindAddressRequest request = new FindAddressRequest();
        request.setState(email);
        try {
            List<FindAddressResponse> responses = addressServices.findByEmail(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }
    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteAddressById(@PathVariable("id") String id) {
        DeleteAddressRequest request = new DeleteAddressRequest();
        request.setId(id);
        try {
            DeleteAddressResponse response = addressServices.delete(request);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(true,exception),BAD_REQUEST);
        }
    }
}
