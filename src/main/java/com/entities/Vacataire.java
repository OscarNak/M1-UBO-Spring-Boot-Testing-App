package com.entities;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue("Vac")
public class Vacataire extends Utilisateur{

    @ManyToOne
    private Cours cours;
}