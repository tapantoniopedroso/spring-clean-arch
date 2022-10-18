package br.com.cleanarch.example;

import br.com.cleanarch.example.user.contract.UserRepository;
import br.com.cleanarch.example.user.entity.User;
import br.com.cleanarch.example.user.usecase.UserServiceImpl;
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
public class UserServiceTest {

    @Mock private UserRepository userRepo;

    @BeforeEach void setUp(){
        User user = new User("awsd2-sde4454feedef-454554", "Thiago Pedroso");

        Mockito.when(userRepo.findById(user.getId())).thenReturn(user);
    }

    @Test
    public void shouldGetUserAndIdReturn(){

        String id = "awsd2-sde4454feedef-454554";
        var service = new UserServiceImpl(userRepo);
        var response = service.find(id);

        assertThat(response.getId()).isEqualTo(id);

    }
}
