package ru.itsjava.rest.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itsjava.domains.Email;
import ru.itsjava.domains.Pet;
import ru.itsjava.domains.User;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String fio;
    private String mail;
    private String pet;


    public UserDto(long id, String fio, String mail, String pet) {
        this.id = id;
        this.fio = fio;
        this.mail = mail;
        this.pet = pet;
    }

    public UserDto(long id, String fio, Email mail, Pet pet) {
    }

//    private static ModelMapper modelMapper=new ModelMapper();

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.id, userDto.fio, new Email(0L, "something@gmail.com"), new Pet(0L, "cat", "Мурзик"));
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getFio(), user.getMail(), user.getPet());
    }
}
