package br.com.cleanarch.example.user.contract;

import br.com.cleanarch.example.user.entity.User;

public interface UserService {

    String save (User user);
    User find(String id);
}
