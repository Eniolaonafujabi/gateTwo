package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.repositories.AddressRepo;
import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.request.DeleteAddressRequest;
import com.semicolon.africa.dtos.request.FindAddressRequest;
import com.semicolon.africa.dtos.response.AddAddressResponse;
import com.semicolon.africa.dtos.response.DeleteAddressResponse;
import com.semicolon.africa.dtos.response.FindAddressResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        assertThat(response1.getId()).isEqualTo(response.getId());
    }

    @Test
    public void testThatYouCanFindByFirstName(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setFirstName(response.getFirstName());
        List<FindAddressResponse> responses = addressService.findByFirstName(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByMiddleName(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setMiddleName(response.getMiddleName());
        List<FindAddressResponse> responses = addressService.findByMiddleName(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByLastName(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setLastName(response.getLastName());
        List<FindAddressResponse> responses = addressService.findByLastName(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByGender(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setGender(response.getGender());
        List<FindAddressResponse> responses = addressService.findByGender(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByCompany(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setCompany(response.getCompany());
        List<FindAddressResponse> responses = addressService.findByCompany(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByAddress1(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setAddress1(response.getAddress1());
        List<FindAddressResponse> responses = addressService.findByAddress1(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByAddress2(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setAddress2(response.getAddress2());
        List<FindAddressResponse> responses = addressService.findByAddress2(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByCityOrTown(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setCityOrTown(response.getCityOrTown());
        List<FindAddressResponse> responses = addressService.findByCityOrTown(request);
        assertThat(responses.size()).isEqualTo(2);
    }
    @Test
    public void testThatYouCanFindByCountry(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setCountry(response.getCountry());
        List<FindAddressResponse> responses = addressService.findByCountry(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByState(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setState(response.getState());
        List<FindAddressResponse> responses = addressService.findByState(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByPhone(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setPhone(response.getPhone());
        List<FindAddressResponse> responses = addressService.findByPhoneNumber(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanFindByEmail(){
        AddAddressResponse response = createAddress();
        createAddress();
        FindAddressRequest request = new FindAddressRequest();
        request.setEmail(response.getEmail());
        List<FindAddressResponse> responses = addressService.findByEmail(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatYouCanDeleteAddress(){
        AddAddressResponse response = createAddress();
        DeleteAddressRequest request = new DeleteAddressRequest();
        request.setId(response.getId());
        DeleteAddressResponse response1 =  addressService.delete(request);
        assertThat(response1.getMessage()).contains("Successfully deleted address");
    }
}