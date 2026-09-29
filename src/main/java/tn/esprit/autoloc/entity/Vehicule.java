package tn.esprit.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.entity.enums.CategorieVehicule;
import tn.esprit.autoloc.entity.enums.StatutVehicule;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;
}
