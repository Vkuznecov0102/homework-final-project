package ru.itsjava.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ru.itsjava.domains.Email;
import ru.itsjava.domains.Pet;
import ru.itsjava.domains.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String fio;
    private Email mail;
    private Pet pet;

    private static ModelMapper modelMapper=new ModelMapper();

    public static User toDomainObject(UserDto userDto){
        return modelMapper.map(userDto,User.class);
    }

    public static UserDto toDto(User user){
        return modelMapper.map(user,UserDto.class);
    }
}
