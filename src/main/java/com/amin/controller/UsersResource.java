package com.amin.controller;

import com.amin.domain.captcha.CaptchaResponse;
import com.amin.domain.users.signin.SignInRequest;
import com.amin.domain.users.signin.SignInResponse;
import com.amin.mapper.UsersMapper;
import com.amin.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersResource {

    private final UsersService service;

    private final UsersMapper mapper;

    @PostMapping("/signing")
    @Operation(summary = "sign in")
    public ResponseEntity<SignInResponse> signIn(SignInRequest request) {
        return new ResponseEntity<>(service.signIn(request), HttpStatus.OK);
    }

    @Operation(summary = "get captcha")
    @GetMapping("/captcha")
    private ResponseEntity<CaptchaResponse> captcha() {
        return new ResponseEntity<>(service.captcha(), HttpStatus.OK);
    }

}
