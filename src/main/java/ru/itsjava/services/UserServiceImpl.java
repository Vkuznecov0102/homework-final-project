package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domains.User;
import ru.itsjava.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User getUserById(long id) {
        return repository.getUserById(id).orElse(null);
    }

    @Override
    public void insertUser(User user) {
        repository.insertUser(user);
    }

    @Override
    public void saveUser(User user) {
        repository.updateUser(user);
    }

    @Override
    public User deleteUser(long id) {
        return repository.deleteUser(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
