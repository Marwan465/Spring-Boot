package com.example.bootstrap.service;

import java.util.List;



import org.springframework.stereotype.Component;

@Component
public interface DogService {


    public List<String> retrieveDogBreed();
    
    public String retrieveDogBreedById(Long id);
    public List<String> retrieveDogNames();

}
