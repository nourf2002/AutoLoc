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
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipement;

    private String libelle;

    // * Equipement <---> * Vehicule (côté inverse)
    @ManyToMany(mappedBy = "equipements")
    @ToString.Exclude
    private List<Vehicule> vehicules;
}
