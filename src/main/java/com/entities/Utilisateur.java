package com.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="utilisateur_type")
public class Utilisateur {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String login;
	private String motDePasse;
	private String nomUsuel;
	private String prenom;
	private String mail;

}
