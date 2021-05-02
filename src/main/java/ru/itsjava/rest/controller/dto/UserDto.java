package ru.itsjava.rest.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
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

    public UserDto(long id, String fio, Email mail, Pet pet) {
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static User toDomainObject(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public static UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
