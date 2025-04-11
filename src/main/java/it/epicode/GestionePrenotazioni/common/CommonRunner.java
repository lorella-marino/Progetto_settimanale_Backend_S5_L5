package it.epicode.GestionePrenotazioni.common;

import it.epicode.GestionePrenotazioni.edifici.Edificio;
import it.epicode.GestionePrenotazioni.edifici.EdificioRepository;
import it.epicode.GestionePrenotazioni.postazioni.Postazione;
import it.epicode.GestionePrenotazioni.postazioni.PostazioneRepository;
import it.epicode.GestionePrenotazioni.postazioni.PostazioneService;
import it.epicode.GestionePrenotazioni.postazioni.tipi.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.prenotazioni.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.prenotazioni.PrenotazioneService;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import it.epicode.GestionePrenotazioni.utenti.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;

@Component
public class CommonRunner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PostazioneService postazioneService;

    @Override
    public void run(String... args) throws Exception {

        // EDIFICI
        Edificio edificio1 = new Edificio();
        edificio1.setNome("Edificio 1");
        edificio1.setIndirizzo("via Roma 1");
        edificio1.setCitta("Milano");
        edificioRepository.save(edificio1);

        Edificio edificio2 = new Edificio();
        edificio2.setNome("Edificio 2");
        edificio2.setIndirizzo("via Lazio 2");
        edificio2.setCitta("Roma");
        edificioRepository.save(edificio2);

        Edificio edificio3 = new Edificio();
        edificio3.setNome("Edificio 3");
        edificio3.setIndirizzo("via Lolli 3");
        edificio3.setCitta("Napoli");
        edificioRepository.save(edificio3);

        // POSTAZIONI
        Postazione postazione1 = new Postazione();
        postazione1.setDescrizione("Sala privata 1A");
        postazione1.setTipoPostazione(TipoPostazione.PRIVATO);
        postazione1.setNumeroMassimoOccupanti(1);
        postazione1.setEdificio(edificio1);
        postazioneRepository.save(postazione1);

        Postazione postazione2 = new Postazione();
        postazione2.setDescrizione("Sala riunioni 3C");
        postazione2.setTipoPostazione(TipoPostazione.SALA_RIUNIONI);
        postazione2.setNumeroMassimoOccupanti(10);
        postazione2.setEdificio(edificio2);
        postazioneRepository.save(postazione2);

        Postazione postazione3 = new Postazione();
        postazione3.setDescrizione("Open Space 2D");
        postazione3.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione3.setNumeroMassimoOccupanti(20);
        postazione3.setEdificio(edificio3);
        postazioneRepository.save(postazione3);

        Postazione postazione4 = new Postazione();
        postazione4.setDescrizione("Open Space 4F");
        postazione4.setTipoPostazione(TipoPostazione.OPENSPACE);
        postazione4.setNumeroMassimoOccupanti(15);
        postazione4.setEdificio(edificio3);
        postazioneRepository.save(postazione4);

        // UTENTI
        Utente utente1 = new Utente();
        utente1.setUsername("mario.rossi");
        utente1.setNomeCompleto("Mario Rossi");
        utente1.setEmail("mario.rossi@example.com");
        utenteRepository.save(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("luca.verdi");
        utente2.setNomeCompleto("Luca Verdi");
        utente2.setEmail("luca.verdi@example.com");
        utenteRepository.save(utente2);

        Utente utente3 = new Utente();
        utente3.setUsername("giuseppe.napoli");
        utente3.setNomeCompleto("Giuseppe Napoli");
        utente3.setEmail("giuseppe.napoli@example.com");
        utenteRepository.save(utente3);

        // date
        LocalDate dataPrenotazione1 = LocalDate.parse("2024-03-01");
        LocalDate dataPrenotazione2 = LocalDate.parse("2025-04-03");

        // PRENOTAZIONI
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

        Prenotazione prenotazione1 = new Prenotazione();
        prenotazione1.setData(dataPrenotazione1);
        prenotazione1.setUtente(utente1);
        prenotazione1.setPostazione(postazione1);
        System.out.println(prenotazioneService.creaPrenotazione(utente1, postazione1, dataPrenotazione1));

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

        Prenotazione prenotazione2 = new Prenotazione();
        prenotazione2.setData(dataPrenotazione2);
        prenotazione2.setUtente(utente2);
        prenotazione2.setPostazione(postazione2);
        System.out.println(prenotazioneService.creaPrenotazione(utente2, postazione2, dataPrenotazione2));

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

        Prenotazione prenotazione3 = new Prenotazione();
        prenotazione3.setData(dataPrenotazione1);
        prenotazione3.setUtente(utente3);
        prenotazione3.setPostazione(postazione3);
        System.out.println(prenotazioneService.creaPrenotazione(utente3, postazione3, dataPrenotazione1));

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

        Prenotazione  prenotazione4 = new Prenotazione();
        prenotazione4.setData(dataPrenotazione2);
        prenotazione4.setUtente(utente1);
        prenotazione4.setPostazione(postazione2);
        System.out.println(prenotazioneService.creaPrenotazione(utente1, postazione2, dataPrenotazione2));

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

        Prenotazione prenotazione5 = new Prenotazione();
        prenotazione5.setData(dataPrenotazione1);
        prenotazione5.setUtente(utente3);
        prenotazione5.setPostazione(postazione3);
        System.out.println(prenotazioneService.creaPrenotazione(utente3, postazione3, dataPrenotazione1));

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();

        System.out.println("🔎 RICERCA DI UNA POSTAZIONE, TRAMITE TIPO E CITTA");
        System.out.println(postazioneService.getPostazioniByTipoECitta(TipoPostazione.OPENSPACE, "Napoli"));

        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }
}