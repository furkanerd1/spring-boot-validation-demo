package com.furkan.validation.demo.mapper;

import com.furkan.validation.demo.model.dto.request.UserCreateRequest;
import com.furkan.validation.demo.model.dto.response.UserResponse;
import com.furkan.validation.demo.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserCreateRequest request);
    UserResponse toResponse(User user);
}
