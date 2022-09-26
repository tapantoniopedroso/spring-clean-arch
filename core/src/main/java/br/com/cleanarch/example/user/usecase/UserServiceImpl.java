package br.com.cleanarch.example.user.usecase;

import br.com.cleanarch.example.user.contract.UserRepository;
import br.com.cleanarch.example.user.contract.UserService;
import br.com.cleanarch.example.user.entity.User;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public void save(User user){
        user.setId(UUID.randomUUID().toString());
        userRepo.save(user);
    }
}
