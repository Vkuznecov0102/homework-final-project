package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.rest.controller.dto.PetDto;
import ru.itsjava.services.PetService;

@RequiredArgsConstructor
@Controller
public class PetController {

    private final PetService petService;

    @GetMapping("/pet")
    public String getPetList(Model model) {
        model.addAttribute("pet", petService.findAll());
        return "pet-list";
    }

    @GetMapping("/pet/{id}/edit")
    public String editPet(@PathVariable("id") String id, Model model) {
        PetDto dto = PetDto.toDto(petService.getPetById(Long.parseLong(id)));
        model.addAttribute("petDto", dto);
        return "pet-edit";
    }

    @DeleteMapping("/pet/{id}/delete")
    public String deletePet(@PathVariable("id") String id, Model model) {
        PetDto dto = PetDto.toDto(petService.deletePet(Long.parseLong(id)));
        model.addAttribute("petDto", dto);
        return "redirect:/";
    }

    @PostMapping("/pet/{id}/edit")
    public String editPet(PetDto petDto) {
        petService.savePet(PetDto.toDomainObject(petDto));
        return "redirect:/";
    }
}
