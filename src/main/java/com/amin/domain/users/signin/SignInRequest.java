package com.amin.domain.users.signin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

    private String username;

    private String password;

    private String captcha;

}
