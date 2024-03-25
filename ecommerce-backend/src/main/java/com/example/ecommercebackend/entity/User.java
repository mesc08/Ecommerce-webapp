package com.example.ecommercebackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Size(min = 2, max = 20, message = "first name should be between 2 to 20 characters long")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "first name should not contain special characters or digits")
    private String firstName;

    @Size(min = 3, max = 20, message = "last name should be between 3 to 20 characters long")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "last name should not contain special characters or digit")
    private String lastName;

    @Size(min=10, max = 10, message = "mobile number should be exactly 10 digits")
    @Pattern(regexp = "^\\d{10}$", message = "mobile number should contain only 10 digits")
    private String mobileNumber;

    @Email
    @Column(unique = true, nullable = false)
    private String emailId;

    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Cart cart;
}
