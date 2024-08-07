package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.repositories.AddressRepo;
import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.request.FindAddressRequest;
import com.semicolon.africa.dtos.response.AddAddressResponse;
import com.semicolon.africa.dtos.response.FindAddressResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressImplTest {

    @Autowired
    private AddressServicesImpl  addressService;

    @Autowired
    private AddressRepo  addressRepo;

    @BeforeEach
    public void setUp() {
        addressRepo.deleteAll();
    }

    private AddAddressResponse createAddress() {
        AddAddressRequest request = new AddAddressRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setMiddleName("whatever");
        request.setGender("Male");
        request.setBirthday("05-56-7000");
        request.setCompany("semicolon");
        request.setAddress1("rrrrr");
        request.setAddress2("rrrrr");
        request.setCityOrTown("shomolu");
        request.setState("Lagos");
        request.setCountry("Nigeria");
        request.setPhone("3333");
        request.setEmail("eniola@mail");
        return addressService.createAddress(request);
    }
    @Test
    public void testAddAddress() {
        AddAddressResponse response = createAddress();
        assertThat(response.getMessage()).contains("Saved Successfully");
    }

    @Test
    public void testThatYouCanFindAddressById(){
        AddAddressResponse response = createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setId(response.getId());
        FindAddressResponse response1 = addressService.findById(request);
        assertThat(response1.getId()).isNotNull();
    }
}