package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_tendera")
public class StatusTendera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Это предполагает, что вы используете автоинкрементный идентификатор
    private Long id_statusa_tendera; // Идентификатор тендера

    private String status_tendera;

    public Long getId_statusa_tendera() {
        return id_statusa_tendera;
    }

    public void setId_statusa_tendera(Long id_statusa_tendera) {
        this.id_statusa_tendera = id_statusa_tendera;
    }

    public String getStatus() {
        return status_tendera;
    }

    public void setStatus(String status) {
        this.status_tendera = status;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "id_statusa_tendera = " + id_statusa_tendera +
                "status" + status_tendera;
    }
}