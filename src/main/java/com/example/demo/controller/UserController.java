package com.example.demo.controller;


import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Testing User Endpoint")
@Deprecated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @Operation(summary = "Get User")
    public List<UserDto> getActiveUsers(
        @RequestParam(defaultValue = "true", required = false) boolean active,
        @RequestParam(required = false) String name
    ) {
        if (active && name != null) {
            userService.filterIsActiveUserName(name, true);
        }
        return userService.filterIsActiveUserName(name, active);
    }

    @PostMapping("/users")
    public ResponseEntity<?> insert(@RequestBody @Valid User user) {
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(
        @PathVariable String id,
        @RequestBody @Valid User user)
    {

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/all")
    public List<UserDto> getAll() {
        return userService.getAll();
    }
}
