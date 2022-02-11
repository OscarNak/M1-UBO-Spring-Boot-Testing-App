package com.services.impl;

import com.dtos.VacataireDto;
import com.entities.Vacataire;
import com.repositories.VacataireRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("vacataireService")
public class VacataireServiceImpl {
    private final VacataireRepository vacRepository;

    public VacataireServiceImpl(VacataireRepository vacRepository) {
        this.vacRepository = vacRepository;
    }

    public VacataireDto saveVacataire(VacataireDto vacataireDto) {
        Vacataire vacataire = vacataireDtoToEntity(vacataireDto);
        vacataire = vacRepository.save(vacataire);
        return vacataireEntityToDto(vacataire);
    }



    private VacataireDto vacataireEntityToDto(Vacataire vacataire) {

        VacataireDto vacataireDto = new VacataireDto();
        vacataireDto.setId(vacataire.getId());
        vacataireDto.setLogin(vacataire.getLogin());
        vacataireDto.setMotDePasse(vacataire.getMotDePasse());
        vacataireDto.setNomUsuel(vacataire.getNomUsuel());
        vacataireDto.setPrenom(vacataire.getPrenom());
        vacataireDto.setMail(vacataire.getMail());
        vacataireDto.setCours(vacataire.getCours());
        return vacataireDto;
    }

    private Vacataire vacataireDtoToEntity(VacataireDto vacataireDto) {
        Vacataire vacataire = new Vacataire();
        vacataire.setId(vacataireDto.getId());
        vacataire.setLogin(vacataireDto.getLogin());
        vacataire.setMotDePasse(vacataireDto.getMotDePasse());
        vacataire.setNomUsuel(vacataireDto.getNomUsuel());
        vacataire.setPrenom(vacataireDto.getPrenom());
        vacataire.setMail(vacataireDto.getMail());
        vacataire.setCours(vacataireDto.getCours());
        return vacataire;
    }

    public List<VacataireDto> getVacataires() {
        List<VacataireDto> vacataireDtos = new ArrayList<>();
        List<Vacataire> vacataires = vacRepository.findAll();
        vacataires.forEach(user -> {
            vacataireDtos.add(vacataireEntityToDto(user));
        });
        return vacataireDtos;
    }

    public VacataireDto getVacataireById(Long id) {
        Vacataire vacataire = vacRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("vacataire not found"));
        return vacataireEntityToDto(vacataire);
    }

    public Boolean deleteVacataire(Long id) {
        vacRepository.deleteById(id);
        return true;
    }
}
