package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_zayavki")
public class StatusZayavkiNaUchastie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Это предполагает, что вы используете автоинкрементный идентификатор
    private Long id_status_zayavki; // Идентификатор заявки

    private String status_zayavki;

    public Long getId_statusa_zayavki() {
        return id_status_zayavki;
    }

    public void setId_statusa_zayavki(Long id_status_zayavki) {
        this.id_status_zayavki = id_status_zayavki;
    }

    public String getStatus() {
        return status_zayavki;
    }

    public void setStatus(String status) {
        this.status_zayavki = status;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "id_statusa_tendera = " + id_status_zayavki +
                "status" + status_zayavki;
    }
}