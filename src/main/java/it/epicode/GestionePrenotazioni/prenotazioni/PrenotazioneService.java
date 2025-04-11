package it.epicode.GestionePrenotazioni.prenotazioni;

import it.epicode.GestionePrenotazioni.postazioni.Postazione;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public String creaPrenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {
        // Verifica se esiste già una prenotazione con quell'Utente e Data
        if (!prenotazioneRepository.existsByUtenteAndData(utente, dataPrenotazione)) {
            // Verifica se la postazione è già prenotata per quella data
            List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndData(postazione, dataPrenotazione);
            if (prenotazioni.isEmpty()) {

                Prenotazione prenotazione = new Prenotazione();
                prenotazione.setData(dataPrenotazione);
                prenotazione.setUtente(utente);
                prenotazione.setPostazione(postazione);
                prenotazioneRepository.save(prenotazione);


                System.out.println("Prenotazione: " +
                        prenotazione.getPostazione().getDescrizione() + " - " +
                        prenotazione.getUtente().getNomeCompleto() + " - " +
                        prenotazione.getData());
                return "✅ Prenotazione creata per: " + utente.getNomeCompleto();
            } else {
                return "❌ Postazione già prenotata per quella data";
            }
        } else {
            return "❌ È già presente una prenotazione per "+ utente.getNomeCompleto() + " in data " + dataPrenotazione ;
        }
    }

}
