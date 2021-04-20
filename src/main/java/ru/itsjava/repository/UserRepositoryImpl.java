package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domains.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(entityManager.find(User.class,id));
    }

    @Override
    public void insertUser(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
        }
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u",User.class);
        return query.getResultList();
    }
}
