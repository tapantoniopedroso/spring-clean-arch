package br.com.cleanarch.example.repository;

import br.com.cleanarch.example.repository.model.UserModel;
import br.com.cleanarch.example.user.contract.UserRepository;
import br.com.cleanarch.example.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserDao userDao;

    @Override
    public String save(User user) {
        var userNew = userDao.save(UserModel.from(user));

        return userNew.getId();
    }

    @Override
    public User findById(String id) {
        var user = userDao.findById(id);

        return user.get().toUser();
    }
}
