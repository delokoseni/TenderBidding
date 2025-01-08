package com.example.TenderBidding.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "zayavka_na_provedenie_tendera")
public class ZayavkaNaProvedenieTendera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZayavkiNaProvedenieTendera;

    private LocalDate dataNachalaTendera;
    private LocalDate dataOkonchaniyaTendera;
    private String usloviya;  // Это поле типа JSON, можно преобразовать в строку
    private Double nachalnayaTsena;
    private Long idOrganizatsii;  // Ссылка на организацию

    // Getters and Setters
    public Long getIdZayavkiNaProvedenieTendera() {
        return idZayavkiNaProvedenieTendera;
    }

    public void setIdZayavkiNaProvedenieTendera(Long idZayavkiNaProvedenieTendera) {
        this.idZayavkiNaProvedenieTendera = idZayavkiNaProvedenieTendera;
    }

    public LocalDate getDataNachalaTendera() {
        return dataNachalaTendera;
    }

    public void setDataNachalaTendera(LocalDate dataNachalaTendera) {
        this.dataNachalaTendera = dataNachalaTendera;
    }

    public LocalDate getDataOkonchaniyaTendera() {
        return dataOkonchaniyaTendera;
    }

    public void setDataOkonchaniyaTendera(LocalDate dataOkonchaniyaTendera) {
        this.dataOkonchaniyaTendera = dataOkonchaniyaTendera;
    }

    public String getUsloviya() {
        return usloviya;
    }

    public void setUsloviya(String usloviya) {
        this.usloviya = usloviya;
    }

    public Double getNachalnayaTsena() {
        return nachalnayaTsena;
    }

    public void setNachalnayaTsena(Double nachalnayaTsena) {
        this.nachalnayaTsena = nachalnayaTsena;
    }

    public Long getIdOrganizatsii() {
        return idOrganizatsii;
    }

    public void setIdOrganizatsii(Long idOrganizatsii) {
        this.idOrganizatsii = idOrganizatsii;
    }
}
