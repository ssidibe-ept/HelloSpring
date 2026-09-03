package com.groupeisi.HelloSpring.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "stages")
public class Stage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sujet_definitif", nullable = false)
    private String sujetDefinitif;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "statut")
    private String statut;

    public Stage() {
    }

    public Stage(String sujetDefinitif, LocalDate dateDebut, LocalDate dateFin, String statut) {
        this.sujetDefinitif = sujetDefinitif;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public Stage(Long id, String sujetDefinitif, LocalDate dateDebut, LocalDate dateFin, String statut) {
        this.id = id;
        this.sujetDefinitif = sujetDefinitif;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSujetDefinitif() {
        return sujetDefinitif;
    }

    public void setSujetDefinitif(String sujetDefinitif) {
        this.sujetDefinitif = sujetDefinitif;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", sujetDefinitif='" + sujetDefinitif + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", statut='" + statut + '\'' +
                '}';
    }
}
