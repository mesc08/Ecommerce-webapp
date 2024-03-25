package com.example.ecommercebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @NotBlank
    @Size(min = 5, message = "street name must contain atleast 5 character long")
    private String street;

    @NotBlank
    @Size(min = 5, message = "building name must contain atleast 5 character long")
    private String buildingName;

    @NotBlank
    @Size(min = 4, message = "city name must contain atleast 4 character long")
    private String city;

    @NotBlank
    @Size(min = 2, message = "state name must contain atleast 2 character long")
    private String state;

    @NotBlank
    @Size(min = 2, message = "country name must contain atleast 2 character long")
    private String country;

    @NotBlank
    @Size(min = 6, message = "pincode must contain atleast 6 character long")
    private String pinCode;

    @ManyToMany(mappedBy = "address")
    private List<User> users = new ArrayList<>();

    public Address(String street, String buildingName, String city, String state, String country, String pinCode){
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

}
