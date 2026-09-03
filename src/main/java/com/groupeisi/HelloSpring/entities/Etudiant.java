package com.groupeisi.HelloSpring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Etudiant {

    @Id
    private String numCarte;

    private String prenom;

    private String nom;

    private String email;

    private String telephone;

    private String formation;

    private String niveau;

    public Etudiant() {
    }

    public Etudiant(String numCarte, String prenom, String nom,
                    String email, String telephone,
                    String formation, String niveau) {
        this.numCarte = numCarte;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.formation = formation;
        this.niveau = niveau;
    }

    public String getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(String numCarte) {
        this.numCarte = numCarte;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
}