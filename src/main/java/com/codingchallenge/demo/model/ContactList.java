package com.codingchallenge.demo.model;

import java.util.List;

public class ContactList implements Comparable<ContactList>{
    private Name name;
    private String homePhone;

    public ContactList(Name name, String homePhone) {
        this.name = name;
        this.homePhone = homePhone;
    }

    public Name getName() {
        return name;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Override
    public int compareTo(ContactList contactList) {
        int last = this.name.getLastName().compareTo(contactList.getName().getLastName());
        return last == 0 ? this.name.getFirstName().compareTo(contactList.getName().getFirstName()) : last;
    }
}
