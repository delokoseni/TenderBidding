package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status_zayavki")
public class StatusZayavki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоинкрементный идентификатор
    private Long id_status_zayavki; // Идентификатор статуса заявки

    private String status_zayavki; // Название статуса заявки

    // Getters и Setters
    public Long getId_status_zayavki() {
        return id_status_zayavki;
    }

    public void setId_status_zayavki(Long id_status_zayavki) {
        this.id_status_zayavki = id_status_zayavki;
    }

    public String getStatus_zayavki() {
        return status_zayavki;
    }

    public void setStatus_zayavki(String status_zayavki) {
        this.status_zayavki = status_zayavki;
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return "StatusZayavki{" +
                "id_status_zayavki=" + id_status_zayavki +
                ", status_zayavki='" + status_zayavki + '\'' +
                '}';
    }
}
