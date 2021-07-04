package com.codingchallenge.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.FilterDef;

import javax.persistence.*;

@Entity
@Table(name = "Phone")
public class Phone {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Enumerated(EnumType.STRING)
    private Type type;
    public Phone() {
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Enum<Type> getType() {
        return type;
    }

    public void setType(Type phoneType) {
        this.type = phoneType;
    }
}
