package com.api.rest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello_1")
    @PreAuthorize("hasRole('admin_client_role')")
    public String helloAdmin() {
        return "Hello Spring Boot With Keycloack - ADMIN";
    }

    @GetMapping("/hello_2")
//    @PreAuthorize("hasRole('user_client_role') or hasRole('admin_client_role')")
    @PreAuthorize("hasAnyRole('user_client_role', 'admin_client_role')")
    public String helloUser() {
        return "Hello Spring Boot With Keycloack - USER";
    }

}
