package com.gabkings.msscbreweryclient.web.client;

import com.gabkings.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerClientTest {
    @Autowired
    CustomerClient client;

    @Test
    void getCustomerById() {
      CustomerDto dto =  client.getCustomerById(UUID.randomUUID());
      assertNotNull(dto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto dto = CustomerDto.builder().name("Gabriel K").build();
        URI uri = client.saveNewCustomer(dto);
        assertNotNull(uri);
    }


    @Test
    void updateCustomer() {
        CustomerDto dto = CustomerDto.builder().name("Gabriel K3").build();
        client.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
}