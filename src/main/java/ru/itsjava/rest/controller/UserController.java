package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.rest.controller.dto.UserDto;
import ru.itsjava.services.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users-list";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") String id, Model model) {
        UserDto dto = UserDto.toDto(userService.getUserById(Long.parseLong(id)));
        model.addAttribute("userDto", dto);
        return "users-edit";
    }

    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        UserDto dto = UserDto.toDto(userService.deleteUser(Long.parseLong(id)));
        model.addAttribute("userDto", dto);
        return "redirect:/";
    }


    @PostMapping("/users/{id}/edit")
    public String editUser(UserDto userDto) {
        userService.saveUser(UserDto.toDomainObject(userDto));
        return "redirect:/";
    }

}