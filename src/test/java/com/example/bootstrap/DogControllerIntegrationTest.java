package com.example.bootstrap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.mapping.List;






@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class DogControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void getAllBreeds() {
        ResponseEntity<List> response = this.restTemplate.getForEntity("http://localhost:"+ port +"/breeds/", List.class);
        assertThat(response.getStatusCode().equals(HttpStatus.OK));
    }
    @Test
    public void getBreedsById() throws Exception {
        ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:"+ port +"/breeds/1/", String.class);
        assertThat(response.getStatusCode().equals(HttpStatus.OK));
    }
    
    
}
