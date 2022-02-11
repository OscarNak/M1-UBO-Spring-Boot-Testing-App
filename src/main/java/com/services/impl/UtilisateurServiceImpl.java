package com.services.impl;

import com.dtos.UtilisateurDto;
import com.entities.Utilisateur;
import com.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service("utilisateurService")
public class UtilisateurServiceImpl{

	private final UtilisateurRepository userRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.userRepository = utilisateurRepository;
    }


    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {

        Utilisateur user = utilisateurDtoToEntity(utilisateurDto);

        user = userRepository.save(user);

        return utilisateurEntityToDto(user);
    }



    private UtilisateurDto utilisateurEntityToDto(Utilisateur user) {
        UtilisateurDto userDto= new UtilisateurDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setMotDePasse(user.getMotDePasse());
        userDto.setNomUsuel(user.getNomUsuel());
        userDto.setPrenom(user.getPrenom());
        userDto.setMail(user.getMail());

        return userDto;
    }

    private Utilisateur utilisateurDtoToEntity(UtilisateurDto userDto) {
        Utilisateur user = new Utilisateur();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setMotDePasse(userDto.getMotDePasse());
        user.setNomUsuel(userDto.getNomUsuel());
        user.setPrenom(userDto.getPrenom());
        user.setMail(userDto.getMail());
        return user;
    }

    public List<UtilisateurDto> getUtilisateurs() {
        List<UtilisateurDto> userDtos = new ArrayList<>();
        List<Utilisateur> users = userRepository.findAll();
        users.forEach(user -> {
            userDtos.add(utilisateurEntityToDto(user));
        });
        return userDtos;
    }

    public UtilisateurDto getUserById(Long id) {
        Utilisateur user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found"));
        return utilisateurEntityToDto(user);
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}