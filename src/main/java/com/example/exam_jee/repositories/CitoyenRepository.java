package com.example.exam_jee.repositories;

import com.example.exam_jee.entities.Citoyen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitoyenRepository extends JpaRepository<Citoyen,Long> {
}
