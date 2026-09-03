package com.groupeisi.HelloSpring.controllers;

import com.groupeisi.HelloSpring.entities.Etudiant;
import com.groupeisi.HelloSpring.services.EtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final EtudiantService  etudiantService;

    @Operation(
            summary = "Liste des étudiants",
            description = "Retourne la liste de tous les etudiant"
    )
    @GetMapping
    private List<Etudiant> getAllEtudiants() {
        return etudiantService.findAll();
    }


    @GetMapping("/{numCarte}")
    public Etudiant getEtudiant(@PathVariable String numCarte) {
        log.info("Getting etudiant with numCarte: {}", numCarte);
        Optional<Etudiant> etudiantBd= etudiantService.findByNumCarte(numCarte);
        //etudiantBd.isEmpty() si c vide
        if (etudiantBd.isPresent()) { //s'il ya un element
            Etudiant etudiant = etudiantBd.get();
            log.info("Etudiant prenom: {}, nom", etudiant.getPrenom(),  etudiant.getNom());
            return etudiant;
        }
        return null;
    }

    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant) {
        log.info("Saving etudiant : {}", etudiant);
        Etudiant result= etudiantService.create(etudiant);
        log.info("Etudiant creer avec succes : {}", result.getNumCarte());
        return result;
    }

    @PutMapping("/{numCarte}")
    public Etudiant update(
            @PathVariable String numCarte,
            @RequestBody Etudiant etudiant) {
        log.info("Updating etudiant : {}", etudiant.getNumCarte());
        Etudiant result=etudiantService.update(etudiant);
        log.info("etudiant cree avec succes");
        return result;
    }

    @DeleteMapping("/{numCarte}")
    public void delete(@PathVariable String numCarte) {
        etudiantService.delete(numCarte);
    }

}
