package ru.itsjava.services;

import ru.itsjava.domains.Email;

import java.util.List;

public interface EmailService {

    Email getEmailById(long id);

    void insertEmail(Email email);

    void saveEmail(Email email);

    Email deleteEmail(long id);

    List<Email> findAll();
}
