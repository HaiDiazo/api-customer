package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> filterUsersByActivity(boolean isActive) {
        return filterUsers(user -> user.isActive() == isActive);
    }

    public List<UserDto> filterIsActiveUserName(String name, boolean isActive) {
        return filterUsers(user -> user.getName().equals(name) && user.isActive() == isActive);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user.getName(), user.getEmail(), user.isActive()))
                .collect(Collectors.toList());
    }

    private List<UserDto> filterUsers(java.util.function.Predicate<User> predicate) {
        return userRepository.findAll().stream()
                .filter(predicate)
                .map(user -> new UserDto(user.getName(), user.getEmail(), user.isActive()))
                .collect(Collectors.toList());
    }
}
