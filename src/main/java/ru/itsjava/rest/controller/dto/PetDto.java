package ru.itsjava.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domains.Pet;

@AllArgsConstructor
@Data
public class PetDto {
    private long id;
    private String type;
    private String name;

    public static Pet toDomainObject(PetDto petDto) {
        return new Pet(petDto.id, petDto.type, petDto.name);
    }

    public static PetDto toDto(Pet pet) {
        return new PetDto(pet.getId(), pet.getType(), pet.getName());
    }
}
