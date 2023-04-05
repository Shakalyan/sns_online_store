package com.sns.online_store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    private String username;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private String role;

}
