package tn.esprit.autoloc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;

    // 1 Contrat <--- 1 Reservation
    // C'est Reservation qui détient la clé étrangère (contrat_id)
    @OneToOne(mappedBy = "contrat")
    @ToString.Exclude
    private Reservation reservation;

    // Contrat ◆──── * Paiement
    @OneToMany(
            mappedBy = "contrat",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<Paiement> paiements;
}
