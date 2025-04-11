package it.epicode.GestionePrenotazioni.postazioni;

import it.epicode.GestionePrenotazioni.edifici.Edificio;
import it.epicode.GestionePrenotazioni.postazioni.tipi.Disponibilita;
import it.epicode.GestionePrenotazioni.postazioni.tipi.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    private int numeroMassimoOccupanti;

    @ManyToOne
    private Edificio edificio;

    @Enumerated(EnumType.STRING)
    private Disponibilita disponibilita = Disponibilita.LIBERA;
}
