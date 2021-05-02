package com.expensetrackersvc.controller.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSignupRequest {

    @NotEmpty(message ="{constraints.NotEmpty.message}")
    private String firstName;
    @NotEmpty(message ="{constraints.NotEmpty.message}")
    private String lastName;
    @NotEmpty(message ="{constraints.NotEmpty.message}")
    private String email;
    @NotEmpty(message ="{constraints.NotEmpty.message}")
    private String password;

    private String mobileNumber;


}
