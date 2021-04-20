package ru.itsjava.repository;

import ru.itsjava.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> getUserById(long id);

    void insertUser(User user);

    void updateUser(User user);

    User deleteUser(long id);

    List<User> findAll();
}
