package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forma_sobstvennosti")
public class OwnershipType {
    @Id
    private Long id_forma_sobstvennnosti; // Исправлено имя поля на правильное

    private String forma;

    // Getters and Setters
    public Long getId_forma_sobstvennnosti() {
        return id_forma_sobstvennnosti;
    }

    public void setId_forma_sobstvennnosti(Long id_forma_sobstvennnosti) {
        this.id_forma_sobstvennnosti = id_forma_sobstvennnosti;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public String toString() {
        return "OwnershipType{id_forma_sobstvennnosti=" + id_forma_sobstvennnosti + ", forma='" + forma + "'}";
    }
}
