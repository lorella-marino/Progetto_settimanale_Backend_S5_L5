package it.epicode.GestionePrenotazioni.postazioni;

import it.epicode.GestionePrenotazioni.postazioni.tipi.TipoPostazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public String getPostazioniByTipoECitta(TipoPostazione tipo, String citta) {
        List<Postazione> postazioni = postazioneRepository.findByTipoPostazioneAndEdificio_Citta(tipo, citta);

        if (postazioni.isEmpty()) {
            return "❌ Nessuna postazione trovata per il tipo '" + tipo + "' nella città '" + citta + "'";
        }

        String risultato = "Postazioni trovate:\n";

        for (Postazione p : postazioni) {
            risultato = risultato + "📍"+
                    p.getDescrizione() +
                    " - Tipo: " + p.getTipoPostazione() +
                    " - Città: " + p.getEdificio().getCitta() +
                    " - Edificio: " + p.getEdificio().getNome() + "\n";
        }

        return risultato;
    }


}
