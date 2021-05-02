package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itsjava.domains.Email;
import ru.itsjava.rest.controller.dto.EmailDto;
import ru.itsjava.services.EmailService;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/email")
    public String getEmailList(Model model) {
        model.addAttribute("email", emailService.findAll());
        return "email-list";
    }

    @RequestMapping(value = "/email/add", method = RequestMethod.GET)
    public String addEmail(Model model, Email email) {
        model.addAttribute("email", Objects.requireNonNullElseGet(email, Email::new));
        return "email-add";
    }

    @PostMapping("/email/add")
    public String addEmail(EmailDto emailDto) {
        emailService.saveEmail(EmailDto.toDomainObject(emailDto));
        return "redirect:/email";
    }

    @GetMapping("/email/{id}/edit")
    public String editEmail(@PathVariable("id") String id, Model model) {
        EmailDto dto = EmailDto.toDto(emailService.getEmailById(Long.parseLong(id)));
        model.addAttribute("emailDto", dto);
        return "email-edit";
    }

    @GetMapping("/email/{id}/delete")
    public String deleteEmail(@PathVariable("id") String id, Model model) {
        EmailDto dto = EmailDto.toDto(emailService.deleteEmail(Long.parseLong(id)));
        model.addAttribute("emailDto", dto);
        return "redirect:/";
    }

    @PostMapping("/email/{id}/edit")
    public String editEmail(EmailDto emailDto) {
        emailService.saveEmail(EmailDto.toDomainObject(emailDto));
        return "redirect:/";
    }
}
