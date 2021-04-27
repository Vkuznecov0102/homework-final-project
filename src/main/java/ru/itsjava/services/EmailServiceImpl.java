package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domains.Email;
import ru.itsjava.repository.EmailRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository repository;

    @Override
    public Email getEmailById(long id) {
        return repository.getEmailById(id).orElse(null);
    }

    @Override
    public void insertEmail(Email email) {
        repository.insertEmail(email);
    }

    @Override
    public void saveEmail(Email email) {
        repository.updateEmail(email);
    }

    @Override
    public Email deleteEmail(long id) {
        return repository.deleteEmail(id);
    }

    @Override
    public List<Email> findAll() {
        return repository.findAll();
    }
}
