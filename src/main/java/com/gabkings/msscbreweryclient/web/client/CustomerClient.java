package com.gabkings.msscbreweryclient.web.client;

import com.gabkings.msscbreweryclient.web.model.BeerDto;
import com.gabkings.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties("sfg.brewery")
public class CustomerClient {
    public final String CUSTOMER_PATH = "/api/v1/customer/";

    private String apiHost;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH+ uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost+CUSTOMER_PATH, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apiHost+CUSTOMER_PATH+uuid.toString(), customerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost+CUSTOMER_PATH+uuid.toString());
    }
}
