package com.odcode.eureka.model;


public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {

}
