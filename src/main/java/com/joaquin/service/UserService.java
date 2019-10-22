package com.joaquin.service;

import com.joaquin.dto.FlattenUserDTO;
import com.joaquin.dto.UserDTO;
import com.joaquin.mapper.UserMapper;
import com.joaquin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@EnableAutoConfiguration
@Service
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getUsers() {
        return userMapper.mapToUsers(userRepository.getUsers());
    }

    public List<FlattenUserDTO> getFlattenUsers() {
        return userRepository.getUsers()
                .stream()
                .map(user -> userMapper.mapToFlattenUser(user))
                .collect(Collectors.toList());
    }

}
