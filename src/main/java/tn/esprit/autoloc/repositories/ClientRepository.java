package tn.esprit.autoloc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.autoloc.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}