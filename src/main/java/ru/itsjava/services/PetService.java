package ru.itsjava.services;

import ru.itsjava.domains.Pet;

import java.util.List;

public interface PetService {

    Pet getPetById(long id);

    void insertPet(Pet pet);

    void savePet(Pet pet);

    Pet deletePet(long id);

    List<Pet> findAll();
}
