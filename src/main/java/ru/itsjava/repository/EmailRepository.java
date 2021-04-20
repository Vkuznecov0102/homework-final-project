package ru.itsjava.repository;

import ru.itsjava.domains.Email;

import java.util.List;
import java.util.Optional;

public interface EmailRepository {
    Optional<Email> getEmailById(long id);

    void insertEmail(Email email);

    void updateEmail(Email email);

    Email deleteEmail(long id);

    List<Email> findAll();
}
