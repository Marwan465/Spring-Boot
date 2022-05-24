package com.example.bootstrap.service;

import java.util.List;

import com.example.bootstrap.entity.location;

import org.springframework.stereotype.Component;



@Component
public interface LocationService {

    public List<location> retrieveLocations();

    public location postLocations(String name);
       
    
    
}
