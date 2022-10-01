package br.com.cleanarch.example;

import br.com.cleanarch.example.converter.UserRequestConverter;
import br.com.cleanarch.example.create.controller.UserController;
import br.com.cleanarch.example.request.UserResponse;
import br.com.cleanarch.example.user.contract.UserService;
import br.com.cleanarch.example.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock private UserService userService;

    @BeforeEach void setUp(){
        User user = new User("awsd2-sde4454feedef-454554", "Thiago Pedroso");
        Mockito.when(userService.find(user.getId())).thenReturn(user);
//        Mockito.when(userService.save(user)).thenReturn(user.getId());
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
}
