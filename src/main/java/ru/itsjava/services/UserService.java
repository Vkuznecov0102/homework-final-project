package ru.itsjava.services;

import ru.itsjava.domains.User;

import java.util.List;

public interface UserService {

    User getUserById(long id);

    void insertUser(User user);

    void saveUser(User user);

    User deleteUser(long id);

    List<User> findAll();
}
