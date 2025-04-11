package it.epicode.GestionePrenotazioni.postazioni;


import it.epicode.GestionePrenotazioni.postazioni.tipi.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipo, String citta);
}
