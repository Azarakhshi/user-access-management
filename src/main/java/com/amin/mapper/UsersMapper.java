package com.amin.mapper;


import org.mapstruct.Mapper;

import javax.persistence.EntityManager;

@Mapper(componentModel = "spring")
public interface UsersMapper extends EntityManager {
}
