package com.example.bootstrap.service;

import java.util.List;

import com.example.bootstrap.entity.location;
import com.example.bootstrap.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRep;
    @Autowired
    location loc;
    @Override
    public List<location> retrieveLocations() {
     
        return (List<location>) locationRep.findAll();
    }
    @Override
    
    public location postLocations(String name) {
        System.out.println(name);
        loc= new location(1,name, "anywhere");
        return locationRep.save(loc);
       
    }
    
}
