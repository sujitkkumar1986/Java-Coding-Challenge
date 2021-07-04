package com.codingchallenge.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CustomerDetails")
@NamedQuery(name = "CustomerDetails.findByHome", query = "SELECT c from CustomerDetails c where c.hasHomePhone = 'true'")
public class CustomerDetails {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(targetEntity = Name.class, cascade = CascadeType.ALL)
    private Name name;
    @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(targetEntity = Phone.class, cascade = CascadeType.ALL)
    private Set<Phone> phone;
    private String email;
    @JsonIgnore
    private String hasHomePhone;

    public CustomerDetails() {
    }
    public CustomerDetails(Long id, Name name, Address address, Set<Phone> phone, String email, String hasHomePhone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.hasHomePhone = hasHomePhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Phone> getPhone() {
        return phone;
    }

    public void setPhone(Set<Phone> phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHasHomePhone() {
        return hasHomePhone;
    }

    public void setHasHomePhone(String hasHomePhone) {
        this.hasHomePhone = hasHomePhone;
    }
}
