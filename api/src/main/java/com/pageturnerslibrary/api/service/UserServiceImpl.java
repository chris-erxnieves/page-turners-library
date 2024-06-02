package com.pageturnerslibrary.api.service;

import com.pageturnerslibrary.api.dto.UserDto;
import com.pageturnerslibrary.api.entity.User;
import com.pageturnerslibrary.api.exception.ResourceNotFoundException;
import com.pageturnerslibrary.api.mapper.UserMapper;
import com.pageturnerslibrary.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto newUserDto) {
        User newUser = UserMapper.mapToUser(newUserDto);
        User savedNewUser = userRepository.save(newUser);
        return UserMapper.mapToUserDto(savedNewUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> foundUsers = userRepository.findAll();
        return foundUsers.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long userId) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return UserMapper.mapToUserDto(foundUser);
    }

    @Override
    public UserDto updateUserById(Long userId, UserDto updatedUserDto) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        foundUser.setFirstName(updatedUserDto.getFirstName());
        foundUser.setLastName(updatedUserDto.getLastName());
        foundUser.setUsername(updatedUserDto.getUsername());
        foundUser.setPassword(updatedUserDto.getPassword());
        User savedUpdatedUser = userRepository.save(foundUser);
        return UserMapper.mapToUserDto(savedUpdatedUser);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepository.deleteById(userId);
    }
}
