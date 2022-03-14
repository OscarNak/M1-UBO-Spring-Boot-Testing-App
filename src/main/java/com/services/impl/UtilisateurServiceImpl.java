package com.services.impl;
import com.dtos.UtilisateurDto;
import com.entities.Utilisateur;
import com.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("utilisateurService")
public class UtilisateurServiceImpl {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {

        Utilisateur utilisateur = utilisateurDtoToEntity(utilisateurDto);
        utilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurEntityToDto(utilisateur);
    }


    private UtilisateurDto utilisateurEntityToDto(Utilisateur utilisateur) {

        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
        utilisateurDto.setNomUsuel(utilisateur.getNomUsuel());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setMail(utilisateur.getMail());
        utilisateurDto.setCours(utilisateur.getCours());
        return utilisateurDto;
    }

    private Utilisateur utilisateurDtoToEntity(UtilisateurDto UtilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(UtilisateurDto.getId());
        utilisateur.setLogin(UtilisateurDto.getLogin());
        utilisateur.setMotDePasse(UtilisateurDto.getMotDePasse());
        utilisateur.setNomUsuel(UtilisateurDto.getNomUsuel());
        utilisateur.setPrenom(UtilisateurDto.getPrenom());
        utilisateur.setMail(UtilisateurDto.getMail());
        utilisateur.setCours(UtilisateurDto.getCours());
        return utilisateur;
    }

    public List<UtilisateurDto> getUtilisateur() {
        List<UtilisateurDto> UtilisateurDtos = new ArrayList<>();
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        utilisateurs.forEach(user -> {
            UtilisateurDtos.add(utilisateurEntityToDto(user));
        });
        return UtilisateurDtos;
    }

    public UtilisateurDto getUtilisateurById(Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("utilisateur not found"));
        return utilisateurEntityToDto(utilisateur);
    }

    public Boolean deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
        return true;
    }
}
