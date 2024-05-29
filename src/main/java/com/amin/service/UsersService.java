package com.amin.service;

import com.amin.entity.Users;
import com.amin.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UsersService {

    private final UsersRepository userRepository;

    public Users signIn(Users users){
        return userRepository.findByUsers(users);
    }

}
