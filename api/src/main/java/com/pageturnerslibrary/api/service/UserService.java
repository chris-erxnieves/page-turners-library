package com.pageturnerslibrary.api.service;

import com.pageturnerslibrary.api.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto newUserDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    UserDto updateUserById(Long userId, UserDto updatedUserDto);

    void deleteUserById(Long userId);
}
