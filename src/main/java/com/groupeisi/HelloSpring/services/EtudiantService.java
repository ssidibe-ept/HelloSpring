package com.groupeisi.HelloSpring.services;

import com.groupeisi.HelloSpring.entities.Etudiant;
import com.groupeisi.HelloSpring.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    public Optional<Etudiant> findByNumCarte(String numCarte) {
        return etudiantRepository.findById(numCarte);
    }

    public Etudiant create(Etudiant etudiant) {
        etudiant=etudiantRepository.save(etudiant);
        return etudiant;
    }

    public Etudiant update(Etudiant etudiant) {
        etudiant=etudiantRepository.save(etudiant);
        return etudiant;
    }

    public void delete(String numCarte) {
        etudiantRepository.deleteById(numCarte);
    }
}
