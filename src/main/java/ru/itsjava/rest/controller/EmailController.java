package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itsjava.domains.Email;
import ru.itsjava.rest.controller.dto.EmailDto;
import ru.itsjava.services.EmailService;

@RequiredArgsConstructor
@Controller
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/email")
    public String getEmailList(Model model) {
        model.addAttribute("email", emailService.findAll());
        return "email-list";
    }

    @RequestMapping(value = "/email/add", method = RequestMethod.PUT)
    public String addEmail(Model model) {
        model.addAttribute("email", new Email());
        return "redirect:/";
    }

    @PostMapping("/email/add")
    public String addEmail(EmailDto emailDto) {
        emailService.saveEmail(EmailDto.toDomainObject(emailDto));
        return "redirect:/";
    }

    @GetMapping("/email/{id}/edit")
    public String editEmail(@PathVariable("id") String id, Model model) {
        EmailDto dto = EmailDto.toDto(emailService.getEmailById(Long.parseLong(id)));
        model.addAttribute("emailDto", dto);
        return "email-edit";
    }

    @DeleteMapping("/email/{id}/delete")
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
