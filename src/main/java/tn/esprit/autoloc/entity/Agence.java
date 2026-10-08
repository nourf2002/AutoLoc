package tn.esprit.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    // 1 Agence ---> * Employe  (One To Many Bidirectionnelle)
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Employe> employes;

    // 1 Agence ---> * Vehicule  (One To Many Bidirectionnelle)
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Vehicule> vehicules;
}
