package com.semicolon.africa.services.interfaces;


import com.semicolon.africa.dtos.request.UpdateAddressRequest;
import com.semicolon.africa.dtos.response.FindAddressResponse;
import com.semicolon.africa.dtos.response.AddAddressResponse;
import com.semicolon.africa.dtos.request.FindAddressRequest;
import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.response.UpdateAddressResponse;

import java.util.List;

public interface AddressServicesInterface {
    AddAddressResponse createAddress(AddAddressRequest request);

    FindAddressResponse findById(FindAddressRequest request);

    List<FindAddressResponse> findByFirstName(FindAddressRequest request);

    List<FindAddressResponse> findByMiddleName(FindAddressRequest request);

    List<FindAddressResponse> findByLastName(FindAddressRequest request);

    List<FindAddressResponse> findByGender(FindAddressRequest request);

    List<FindAddressResponse> findByCompany(FindAddressRequest request);

    List<FindAddressResponse> findByAddress1(FindAddressRequest request);

    List<FindAddressResponse> findByAddress2(FindAddressRequest request);

    List<FindAddressResponse> findByCityOrTown(FindAddressRequest request);

    List<FindAddressResponse> findByCountry(FindAddressRequest request);

    List<FindAddressResponse> findByState(FindAddressRequest request);

    List<FindAddressResponse> findByPhoneNumber(FindAddressRequest request);

    List<FindAddressResponse> findByEmail(FindAddressRequest request);

    UpdateAddressResponse update(UpdateAddressRequest request);
}
