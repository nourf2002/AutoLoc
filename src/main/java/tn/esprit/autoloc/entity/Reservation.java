package tn.esprit.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.autoloc.entity.enums.StatutReservation;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // * Reservation ---> 1 Vehicule  (Many To One Bidirectionnelle)
    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    // * Reservation ---> 1 Client  (Many To One Bidirectionnelle)
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // 1 Reservation ---> 1 Contrat  (One To One Bidirectionnelle, Reservation = côté propriétaire)
    // Reservation détient la clé étrangère contrat_id
    @OneToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat;
}
