package tn.esprit.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.entity.enums.CategorieVehicule;
import tn.esprit.autoloc.entity.enums.StatutVehicule;

import java.math.BigDecimal;
import java.util.List;

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

    // * Vehicule ---> 1 Agence  (Many To One Bidirectionnelle)
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    // 1 Vehicule ---> * Maintenance  (One To Many Bidirectionnelle)
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Maintenance> maintenances;

    // * Vehicule <---> * Equipement  (Many To Many Bidirectionnelle, Vehicule = côté propriétaire)
    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    @ToString.Exclude
    private List<Equipement> equipements;

    // 1 Vehicule ---> * Reservation  (One To Many Bidirectionnelle)
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Reservation> reservations;
}
