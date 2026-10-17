package tn.esprit.autoloc.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.entity.Contrat;
import tn.esprit.autoloc.services.IContratService;



import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratController {

    private final IContratService contratService;

    // Ajouter un contrat
    @PostMapping
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    // Modifier un contrat
    @PutMapping
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    // Afficher tous les contrats
    @GetMapping
    public List<Contrat> getAll() {
        return contratService.consulterContrats();
    }

    // Consulter un contrat par ID
    @GetMapping("/getById/{idContrat}")
    public Contrat getContratById(
            @PathVariable Long idContrat) {
        return contratService.consulterContratById(idContrat);
    }

    // Supprimer un contrat par ID
    @DeleteMapping("/delete/{idContrat}")
    public void deleteById(
            @PathVariable Long idContrat) {
        contratService.supprimerContratById(idContrat);
    }
}
