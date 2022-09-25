package br.com.cleanarch.example.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class User {
    private String id;
    private String name;

    public User(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
