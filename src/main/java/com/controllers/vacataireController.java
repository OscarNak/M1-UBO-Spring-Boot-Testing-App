package com.controllers;


import com.dtos.VacataireDto;
import com.services.impl.VacataireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacataire")
public class vacataireController {

    private final VacataireServiceImpl vacService;

    public vacataireController(VacataireServiceImpl vacService) {
        this.vacService = vacService;
    }

    @GetMapping
    public List<VacataireDto> getVacataires(){
        return vacService.getVacataires();
    }

    @GetMapping("/{id}")
    public VacataireDto getVacataire(@PathVariable Long id){
        return vacService.getVacataireById(id);
    }

    @PostMapping
    public VacataireDto saveVacataire(final @RequestBody VacataireDto vacDto){
        return vacService.saveVacataire(vacDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteVacataire(@PathVariable Long id){
        return vacService.deleteVacataire(id);
    }
}
