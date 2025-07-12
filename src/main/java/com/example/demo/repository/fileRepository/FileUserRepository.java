package com.example.demo.repository.fileRepository;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FileUserRepository implements UserRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<User> findAll() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("users.json")) {
            return Arrays.asList(objectMapper.readValue(is, User[].class));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read users from file", e);
        }
    }
}
