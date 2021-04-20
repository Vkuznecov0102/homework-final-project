package ru.itsjava.repository;

import ru.itsjava.domains.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Optional<Pet> getPetById(long id);

    void insertPet(Pet pet);

    void updatePet(Pet pet);

    Pet deletePet(long id);

    List<Pet> findAll();
}
