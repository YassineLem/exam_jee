package com.example.exam_jee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CentreVaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;
    private String adresse;
    @OneToMany(mappedBy="centreVaccination",fetch = FetchType.LAZY)
    private List<Citoyen> citoyenList ;


}
