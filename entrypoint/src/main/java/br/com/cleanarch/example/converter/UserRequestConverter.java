package br.com.cleanarch.example.converter;

import br.com.cleanarch.example.request.UserRequest;
import br.com.cleanarch.example.request.UserResponse;
import br.com.cleanarch.example.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestConverter {

    public User toUser(UserRequest request){

        return  User.from(request.getName());
    }

    public UserResponse fromUser(User user){
        return new UserResponse(user.getName());
    }
}
