package com.groupeisi.HelloSpring.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
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

    @PrePersist
    @PreUpdate
    public void onCreate() {
        if (email != null) {
            email = email.toLowerCase().trim();
        }
    }

}