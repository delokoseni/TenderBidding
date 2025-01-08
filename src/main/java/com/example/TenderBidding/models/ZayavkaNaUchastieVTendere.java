package com.example.TenderBidding.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "zayavka_na_uchastie_v_tendere")
public class ZayavkaNaUchastieVTendere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Или другой подходящий метод
    @Column(name = "id_zayavki_na_uchastie_v_tendere")
    private Long idZayavkiNaUchastieVTendere;

    @Column(name = "tsena_uchastnika")
    private Double tsenaUchastnika;

    @Column(name = "id_organizatsiya")
    private Long idOrganizatsiya;

    @Column(name = "id_tendera")
    private Long idTendera;

    @Column(name = "data_podachi")
    private LocalDate dataPodachi;

    @Column(name = "dokumenty")
    private String dokumenty;  // JSON данные

    @Column(name = "id_status_zayavki")
    private Long idStatusZayavki;

    @Column(name = "data_izmeneniya_statusa")
    private LocalDate dataIzmeneniyaStatusa;

    // Getters and Setters
    public Long getIdZayavkiNaUchastieVTendere() {
        return idZayavkiNaUchastieVTendere;
    }

    public void setIdZayavkiNaUchastieVTendere(Long idZayavkiNaUchastieVTendere) {
        this.idZayavkiNaUchastieVTendere = idZayavkiNaUchastieVTendere;
    }

    public Double getTsenaUchastnika() {
        return tsenaUchastnika;
    }

    public void setTsenaUchastnika(Double tsenaUchastnika) {
        this.tsenaUchastnika = tsenaUchastnika;
    }

    public Long getIdOrganizatsiya() {
        return idOrganizatsiya;
    }

    public void setIdOrganizatsiya(Long idOrganizatsiya) {
        this.idOrganizatsiya = idOrganizatsiya;
    }

    public Long getIdTendera() {
        return idTendera;
    }

    public void setIdTendera(Long idTendera) {
        this.idTendera = idTendera;
    }

    public LocalDate getDataPodachi() {
        return dataPodachi;
    }

    public void setDataPodachi(LocalDate dataPodachi) {
        this.dataPodachi = dataPodachi;
    }

    public String getDokumenty() {
        return dokumenty;
    }

    public void setDokumenty(String dokumenty) {
        this.dokumenty = dokumenty;
    }

    public Long getIdStatusZayavki() {
        return idStatusZayavki;
    }

    public void setIdStatusZayavki(Long idStatusZayavki) {
        this.idStatusZayavki = idStatusZayavki;
    }

    public LocalDate getDataIzmeneniyaStatusa() {
        return dataIzmeneniyaStatusa;
    }

    public void setDataIzmeneniyaStatusa(LocalDate dataIzmeneniyaStatusa) {
        this.dataIzmeneniyaStatusa = dataIzmeneniyaStatusa;
    }
}
