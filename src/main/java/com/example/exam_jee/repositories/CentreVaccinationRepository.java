package com.example.exam_jee.repositories;

import com.example.exam_jee.entities.CentreVaccination;
import com.example.exam_jee.entities.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination,Long> {
    CentreVaccination findByNom(String kw);
}
