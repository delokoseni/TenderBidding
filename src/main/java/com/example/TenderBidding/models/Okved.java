package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "okved")
public class Okved {
    @Id
    private Long id_okved; // или другой подходящий тип для идентификатора

    private String kod;
    private String rasshifrovka;

    // Getters and Setters
    public Long getId_okved() {
        return id_okved;
    }

    public void setId_okved(Long id_okved) {
        this.id_okved = id_okved;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getRasshifrovka() {
        return rasshifrovka;
    }

    public void setRasshifrovka(String rasshifrovka) {
        this.rasshifrovka = rasshifrovka;
    }

    @Override
    public String toString() {
        return "Okved{id=" + id_okved + ", kod='" + kod + "', rasshifrovka='" + rasshifrovka + "'}";
    }
}
