package com.example.bootstrap.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
    private String name;
    
    private String address;
    public location() {}
    public location(long id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address=address;
    }
    public location(String name, String address) {
        
        this.name=name;
        this.address=address;
    }

    

    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
