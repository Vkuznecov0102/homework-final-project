package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domains.Email;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmailRepositoryImpl implements EmailRepository{

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Email> getEmailById(long id) {
        return Optional.ofNullable(entityManager.find(Email.class, id));
    }

    @Override
    public void insertEmail(Email email) {
        if (email.getId() == 0L) {
            entityManager.persist(email);
        }
        entityManager.merge(email);
    }

    @Override
    @Transactional
    public void updateEmail(Email email) {
        entityManager.merge(email);
    }

    @Override
    @Transactional
    public Email deleteEmail(long id) {
        Email email = entityManager.find(Email.class, id);
        entityManager.remove(email);
        return email;
    }

    @Override
    public List<Email> findAll() {
        TypedQuery<Email> query = entityManager.createQuery("select e from Email e", Email.class);
        return query.getResultList();
    }
}
