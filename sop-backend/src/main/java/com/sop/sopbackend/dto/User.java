package com.sop.sopbackend.dto;

import lombok.Data;

@Data
public class User {

    private Long id;

    private String email;

    private String password;

    private String role;

    private Boolean isAuthenticated;
}
