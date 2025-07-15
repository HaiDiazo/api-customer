package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class User {

    private String id;
    private String name;
    private String email;
    private boolean active;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
