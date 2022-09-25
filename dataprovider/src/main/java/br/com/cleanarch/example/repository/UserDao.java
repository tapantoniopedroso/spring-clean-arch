package br.com.cleanarch.example.repository;

import br.com.cleanarch.example.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity, String> {
}
