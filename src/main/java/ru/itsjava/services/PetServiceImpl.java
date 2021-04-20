package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itsjava.domains.Pet;
import ru.itsjava.repository.PetRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PetServiceImpl implements PetService{

    private final PetRepository repository;

    @Override
    public Pet getPetById(long id) {
        return repository.getPetById(id).orElse(null);
    }

    @Override
    public void insertPet(Pet pet) {
        repository.insertPet(pet);
    }

    @Override
    public void savePet(Pet pet) {
        repository.updatePet(pet);
    }

    @Override
    public Pet deletePet(long id) {
        return repository.deletePet(id);
    }

    @Override
    public List<Pet> findAll() {
        return repository.findAll();
    }
}
