package com.example.testing.users.dto;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserDTO implements Serializable {
    private static final long serialVersionUUID =  1L;
    String id;
    String name;
    Double amountToBeTaken;
    Double amountToBeGiven;
    Double totalBalance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
