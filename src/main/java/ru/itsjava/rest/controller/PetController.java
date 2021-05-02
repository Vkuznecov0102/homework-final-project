package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itsjava.domains.Pet;
import ru.itsjava.rest.controller.dto.PetDto;
import ru.itsjava.services.PetService;

import java.util.Objects;

@RequiredArgsConstructor
@Controller
public class PetController {

    private final PetService petService;

    @GetMapping("/pet")
    public String getPetList(Model model) {
        model.addAttribute("pet", petService.findAll());
        return "pet-list";
    }

    @RequestMapping(value = "/pet/add", method = RequestMethod.GET)
    public String addPet(Model model, Pet pet) {
        model.addAttribute("pet", Objects.requireNonNullElseGet(pet, Pet::new));
        return "pet-add";
    }

    @PostMapping("/pet/add")
    public String addPet(PetDto petDto) {
        petService.savePet(PetDto.toDomainObject(petDto));
        return "redirect:/pet";
    }

    @GetMapping("/pet/{id}/edit")
    public String editPet(@PathVariable("id") String id, Model model) {
        PetDto dto = PetDto.toDto(petService.getPetById(Long.parseLong(id)));
        model.addAttribute("petDto", dto);
        return "pet-edit";
    }

    @GetMapping("/pet/{id}/delete")
    public String deletePet(@PathVariable("id") String id, Model model) {
        PetDto dto = PetDto.toDto(petService.deletePet(Long.parseLong(id)));
        model.addAttribute("petDto", dto);
        return "redirect:/pet";
    }

    @PostMapping("/pet/{id}/edit")
    public String editPet(PetDto petDto) {
        petService.savePet(PetDto.toDomainObject(petDto));
        return "redirect:/";
    }
}