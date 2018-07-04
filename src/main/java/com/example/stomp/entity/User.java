package com.example.stomp.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID=1L;

    private String address;
    private String name;
    private int age;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
