package br.com.cleanarch.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;

    public static User from(String name){
        User user = new User();
        user.name = name;

        return user;
    }



}
