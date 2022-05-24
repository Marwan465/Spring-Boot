package com.example.bootstrap.web;

import java.util.List;

import com.example.bootstrap.entity.location;
import com.example.bootstrap.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController

public class LocationController {
    private LocationService locationService;
    
    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService =locationService;
    }
    @GetMapping("/location")
    public ResponseEntity<List<location>> getAllLocations() {
        System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
        List<location> list = locationService.retrieveLocations();
        return new ResponseEntity<List<location>>(list, HttpStatus.OK);
        
    }
    @GetMapping("/location/{name}")
    public ResponseEntity<location> addLocations(@PathVariable("name") String name) {
       System.out.println(name);
        location loc=locationService.postLocations(name);
        return new ResponseEntity<location>(loc, HttpStatus.OK);
        
    }
    @GetMapping("/loc")
    public String addnew() {
      
        return "EEEEEEEEEEEEEEEEEH";
        
    }
  

    
}
