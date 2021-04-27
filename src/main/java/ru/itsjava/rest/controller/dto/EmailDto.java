package ru.itsjava.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domains.Email;

@AllArgsConstructor
@Data
public class EmailDto {

    private long id;
    private String address;

    public static Email toDomainObject(EmailDto emailDto) {
        return new Email(emailDto.id, emailDto.address);
    }

    public static EmailDto toDto(Email email) {
        return new EmailDto(email.getId(), email.getAddress());
    }
}
