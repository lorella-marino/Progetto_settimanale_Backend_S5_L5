package it.epicode.GestionePrenotazioni.utenti;

import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Utente")

public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String nomeCompleto;
    private String email;
    @ManyToOne
    private Set<Prenotazione> prenotazioni = new HashSet<>();


}