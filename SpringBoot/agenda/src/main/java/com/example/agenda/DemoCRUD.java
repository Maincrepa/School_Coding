package com.example.agenda;

import com.example.agenda.model.Contacte;
import com.example.agenda.repository.ContacteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component   // <- Spring crea aquest objecte i l'executa a l'arrencada
public class DemoCRUD implements CommandLineRunner {

    private final ContacteRepository repo;

    public DemoCRUD(ContacteRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n========== DEMO CRUD ==========");

        // C: CREATE
        Contacte nou = new Contacte("Anna", "600999000", "anna@mail.com");
        repo.save(nou);
        System.out.println("✓ Creat: " + nou.getNom() + " amb id=" + nou.getId());

        // R: READ
        long total = repo.count();
        System.out.println("✓ Total contactes a la BBDD: " + total);

        // U: UPDATE
        Contacte c = repo.findById(nou.getId()).orElseThrow();
        c.setTelefon("611222333");
        repo.save(c);
        System.out.println("✓ Actualitzat el telefon d'Anna");

        // D: DELETE  (comenta aquesta linia si vols veure la fila a Workbench)
        // repo.deleteById(nou.getId());
        // System.out.println("✓ Esborrat");

        System.out.println("===============================\n");
    }
}