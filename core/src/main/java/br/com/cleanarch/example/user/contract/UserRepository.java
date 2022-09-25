package br.com.cleanarch.example.user.contract;

import br.com.cleanarch.example.user.entity.User;

public interface UserRepository {

    void save(User user);
}
