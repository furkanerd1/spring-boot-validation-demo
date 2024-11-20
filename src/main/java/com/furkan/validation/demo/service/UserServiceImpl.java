package com.furkan.validation.demo.service;

import com.furkan.validation.demo.exception.BusinessException;
import com.furkan.validation.demo.mapper.UserMapper;
import com.furkan.validation.demo.model.dto.request.UserCreateRequest;
import com.furkan.validation.demo.model.dto.response.UserResponse;
import com.furkan.validation.demo.model.entity.User;
import com.furkan.validation.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse createUser(UserCreateRequest request) {
        if(userRepository.existsByEmail(request.email())){
            throw new BusinessException("This mail address is already in use");
        }
        User newUser = userMapper.toEntity(request);
        userRepository.save(newUser);
        log.info("Created new user with id: {}", newUser.getId());
        return userMapper.toResponse(newUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return userMapper.toResponses(users);
    }
}
