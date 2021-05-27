package com.gabkings.msscbreweryclient.web.client;

import com.gabkings.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);

    }

    @Test
    void saveNewBeer(){
        BeerDto dto = BeerDto.builder().beerName("Tusker Lagger").beerStyle("Refreshing Beer").upc(12L).build();
        URI url = breweryClient.saveNewBeer(dto);

        assertNotNull(url);

    }

    @Test
    void testUpdateBeer(){
        BeerDto dto = BeerDto.builder().beerName("Tusker Lagger").beerStyle("Refreshing Beer").upc(12L).build();
        breweryClient.updateBeer(UUID.randomUUID(), dto);
    }

    @Test
    void testDeleteBeer(){
        breweryClient.deleteBeer(UUID.randomUUID());
    }

}