package com.amin.domain.users.signin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse {

    private String username;

    private String password;

    private String captcha;

    private String userId;

}
