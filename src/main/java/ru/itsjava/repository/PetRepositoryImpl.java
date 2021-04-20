package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domains.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PetRepositoryImpl implements PetRepository{

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Optional<Pet> getPetById(long id) {
        return Optional.ofNullable(entityManager.find(Pet.class, id));
    }

    @Override
    public void insertPet(Pet pet) {
        if (pet.getId() == 0L) {
            entityManager.persist(pet);
        }
        entityManager.merge(pet);
    }

    @Override
    @Transactional
    public void updatePet(Pet pet) {
        entityManager.merge(pet);
    }

    @Override
    @Transactional
    public Pet deletePet(long id) {
        Pet pet = entityManager.find(Pet.class, id);
        entityManager.remove(pet);
        return pet;
    }

    @Override
    public List<Pet> findAll() {
        TypedQuery<Pet> query = entityManager.createQuery("select p from Pet p", Pet.class);
        return query.getResultList();
    }
}
