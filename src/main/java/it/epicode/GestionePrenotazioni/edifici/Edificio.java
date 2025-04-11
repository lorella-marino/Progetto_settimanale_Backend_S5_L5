package it.epicode.GestionePrenotazioni.edifici;

import it.epicode.GestionePrenotazioni.postazioni.Postazione;
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
@Table(name = "Edifici")

public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String indirizzo;
    private String citta;
    @ManyToOne
    private Set<Postazione> postazioni = new HashSet<>();;


}