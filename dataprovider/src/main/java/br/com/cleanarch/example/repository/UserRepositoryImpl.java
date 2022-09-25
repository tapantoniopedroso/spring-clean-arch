package br.com.cleanarch.example.repository;

import br.com.cleanarch.example.repository.entity.UserEntity;
import br.com.cleanarch.example.user.contract.UserRepository;
import br.com.cleanarch.example.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(UserEntity.from(user));
    }
}
