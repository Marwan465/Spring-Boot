package com.example.bootstrap.web;

import java.util.List;

import com.example.bootstrap.service.DogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class DogController {
    @Autowired
    DogService dogServ;

    @GetMapping("/breeds")
    public ResponseEntity<List<String>> getAllBreeds(){
        List<String> list = dogServ.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);

    }
    @GetMapping("/breeds/{id}")
    public ResponseEntity<String> getBreedsById(@PathVariable("id") Long id){
        String brd = dogServ.retrieveDogBreedById(id);
        return new ResponseEntity<String>(brd, HttpStatus.OK);

    }
    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllNames(){
        List<String> list = dogServ.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);

    }

}
