package com.controllers;
import com.dtos.UtilisateurDto;
import com.services.impl.UtilisateurServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class utilisateurController {

    private final UtilisateurServiceImpl utilisateurService;

    public utilisateurController(UtilisateurServiceImpl utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<UtilisateurDto> getUtilisateur(){
        return utilisateurService.getUtilisateur();
    }

    @GetMapping("/{id}")
    public UtilisateurDto getUtilisateur(@PathVariable Long id){
        return utilisateurService.getUtilisateurById(id);
    }

    @PostMapping
    public UtilisateurDto saveUtilisateur(final @RequestBody UtilisateurDto utilisateurDto){
        return utilisateurService.saveUtilisateur(utilisateurDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteUtilisateur(@PathVariable Long id){
        return utilisateurService.deleteUtilisateur(id);
    }
}
