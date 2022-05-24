package com.example.bootstrap.web;


import com.example.bootstrap.service.DogService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(DogController.class)

public class DogControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DogService dogService;

    @Test
    public void getAllBreeds() throws Exception {
        mockMvc.perform(get("/breeds/"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(content().json("[]"));
        verify(dogService,times(1)).retrieveDogBreed();
            
    }
    @Test
    public void getBreedsById() throws Exception {
        mockMvc.perform(get("/breeds/1"))
               .andExpect(status().isOk());

        verify(dogService,times(1)).retrieveDogBreedById((long) 1);
    }
    
}
