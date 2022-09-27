package br.com.cleanarch.example.create.controller;

import br.com.cleanarch.example.converter.UserRequestConverter;
import br.com.cleanarch.example.request.UserRequest;
import br.com.cleanarch.example.user.contract.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;
    @Autowired
    UserRequestConverter requestConverter;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") String id){
        var user = userService.find(id);

        return ResponseEntity.ok(requestConverter.fromUser(user));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody UserRequest request){

        var user = requestConverter.toUser(request);
        var id = userService.save(user);

        return ResponseEntity.ok(
                String.format("{\"id\":%s}", id)
        );

    }
}
