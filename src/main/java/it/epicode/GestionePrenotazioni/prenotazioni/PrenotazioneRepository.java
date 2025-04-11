package it.epicode.GestionePrenotazioni.prenotazioni;


import it.epicode.GestionePrenotazioni.postazioni.Postazione;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByUtenteAndData(Utente utente, LocalDate data);
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);

}
