package com.services.impl;
import com.dtos.CoursDto;
import com.entities.Cours;
import com.repositories.CoursRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("coursService")
public class CoursServiceImpl {
    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public CoursDto saveCours(CoursDto coursDto){
        Cours cours = coursDtoToEntity(coursDto);
        cours = coursRepository.save(cours);
        return coursEntityToDto(cours);
    }

    public List<CoursDto> getCours() {
        List<CoursDto> CoursDtos = new ArrayList<>();
        List<Cours> listeCours = coursRepository.findAll();
        listeCours.forEach(unCours -> {
            CoursDtos.add(coursEntityToDto(unCours));
        });
        return CoursDtos;
    }

    public Boolean deleteCours(Long id) {
        coursRepository.deleteById(id);
        return true;
    }

    public CoursDto getCoursById(Long id) {
        Cours cours = coursRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("cours not found"));
        return coursEntityToDto(cours);
    }



    //CONVERSIONS

    private CoursDto coursEntityToDto(Cours cours) {
        CoursDto coursDto = new CoursDto();
        coursDto.setIntitue(cours.getIntitule());
        coursDto.setId(cours.getId());

        return coursDto;
    }

    private Cours coursDtoToEntity(CoursDto coursDto){
        Cours cours = new Cours();
        cours.setId(cours.getId());
        cours.setIntitule(cours.getIntitule());
        return cours;
    }
}
