package br.com.cleanarch.example.repository.entity;

/*
classe simboliza o model usado para persistencia no banco
 */

import br.com.cleanarch.example.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    private String id;
    private String name;

    public static UserEntity from(User user) {
        return new UserEntity(user.getId(), user.getName());
    }
}
