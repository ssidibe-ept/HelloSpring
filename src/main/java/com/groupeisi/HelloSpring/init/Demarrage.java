package com.groupeisi.HelloSpring.init;

import com.groupeisi.HelloSpring.entities.Etudiant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class Demarrage implements CommandLineRunner {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        log.info("Demarrage"); //trace/debug/info/warn/error
        log.debug("Creation d'un etudiant");
        Etudiant etudiant = new Etudiant();

        log.trace("ajout num carte");
        etudiant.setNumCarte("A12345");
        log.trace("ajout email");
        etudiant.setEmail("afall@gmail.com");
        log.info("enregistrement d'un etudiant");
        em.persist(etudiant);
        log.warn("test warn");
        log.error("test  error");
    }
}
