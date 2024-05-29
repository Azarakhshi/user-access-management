package com.amin.mapper;


import com.amin.domain.users.signin.SignInRequest;
import com.amin.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper extends EntityMapper<SignInRequest, Users> {

}
