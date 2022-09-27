package br.com.cleanarch.example.user.contract;

import br.com.cleanarch.example.user.entity.User;

public interface UserRepository {

    String save(User user);

    //T by Caique
    User findById(String id);
}
