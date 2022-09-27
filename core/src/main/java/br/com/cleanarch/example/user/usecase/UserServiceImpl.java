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

    public String save(User user){
        user.setId(UUID.randomUUID().toString());
        return userRepo.save(user);
    }

    @Override
    public User find(String id) {
        return userRepo.findById(id);
    }
}
