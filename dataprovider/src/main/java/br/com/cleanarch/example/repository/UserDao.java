package br.com.cleanarch.example.repository;

import br.com.cleanarch.example.repository.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserModel, String> {
}
