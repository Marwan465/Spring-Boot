package com.example.bootstrap.service;

import java.util.List;
import java.util.Optional;

import com.example.bootstrap.repository.DogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRep;
    @Override
    public List<String> retrieveDogBreed() {
        return dogRep.findAllBreed();
        
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRep.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    @Override
    public List<String> retrieveDogNames() {
        return  dogRep.findAllName();
       
    }
    
}
