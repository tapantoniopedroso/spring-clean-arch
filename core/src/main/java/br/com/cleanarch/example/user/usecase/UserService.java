package br.com.cleanarch.example.user.usecase;

import br.com.cleanarch.example.user.contract.UserRepository;
import br.com.cleanarch.example.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    public void save(User user){
        userRepo.save(user);
    }
}
