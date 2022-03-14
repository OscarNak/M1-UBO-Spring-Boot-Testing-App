package com.repositories;

import com.entities.Cours;
import com.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
