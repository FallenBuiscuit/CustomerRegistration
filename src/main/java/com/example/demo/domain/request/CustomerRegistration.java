package com.example.demo.domain.request;

import javax.validation.constraints.NotEmpty;

public class CustomerRegistration {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
