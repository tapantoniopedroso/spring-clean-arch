package br.com.cleanarch.example;

import br.com.cleanarch.example.converter.UserRequestConverter;
import br.com.cleanarch.example.create.controller.UserController;
import br.com.cleanarch.example.request.UserRequest;
import br.com.cleanarch.example.request.UserResponse;
import br.com.cleanarch.example.user.contract.UserService;
import br.com.cleanarch.example.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserControllerTest {

    @Mock private UserService userService;


    @BeforeEach void setUp(){
        User user = new User("awsd2-sde4454feedef-454554", "Thiago Pedroso");

        Mockito.when(userService.save(Mockito.any(User.class))).thenReturn(user.getId());
        Mockito.when(userService.find(user.getId())).thenReturn(user);
    }

    @Test
    public void shouldGetUserControllerStatusCode200Return(){

        String id = "awsd2-sde4454feedef-454554";
        var controler = new UserController(userService);
        var response = controler.getUser(id);

        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

    }
    @Test
    public void shouldGetUserControllerBodyUserNameReturn(){
        String id = "awsd2-sde4454feedef-454554";
        var userResponse = new UserResponse("Thiago Pedroso");
        var controler = new UserController(userService);
        var response = controler.getUser(id);

        assertThat(response.getBody()).isEqualTo(userResponse);

    }
    @Test
    public void shouldPostUserControllerAndStatus20Return(){

        var userRequest = new UserRequest("Thiago Pedroso");
        var controler = new UserController(userService);
        var response = controler.save(userRequest);

        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

    }
    @Test
    public void shouldPostUserControllerAndIdReturn(){
        String id = "awsd2-sde4454feedef-454554";
        var userRequest = new UserRequest("Thiago Pedroso");
        var controler = new UserController(userService);
        var response = controler.save(userRequest);

        assertThat(response.getBody()).isEqualTo(String.format("{\"id\":%s}", id));

    }
}
