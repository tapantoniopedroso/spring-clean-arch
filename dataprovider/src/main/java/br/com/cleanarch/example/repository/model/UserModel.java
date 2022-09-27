package br.com.cleanarch.example.repository.model;

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
public class UserModel {

    @Id
    private String id;
    private String name;

    public static UserModel from(User user) {
        return new UserModel(user.getId(), user.getName());
    }
    public User toUser(){
        return new User(this.id, this.name);
    }
}
