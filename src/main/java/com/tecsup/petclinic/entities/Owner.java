package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "owners")
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String city;

    public Owner() {}

    public Owner(Integer id, String name, String address, String city) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Owner(String name, String address, String city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
}

