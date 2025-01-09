package com.example.TenderBidding.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "zayavka_na_uchastie_v_tendere")
public class ZayavkaNaUchastieVTendere {

    @Id
    @Column(name = "id_zayavki_na_uchastie_v_tendere")
    private Long idZayavkiNaUchastieVTendere;

    @Column(name = "tsena_uchastnika")
    private Double tsenaUchastnika;

    @Column(name = "id_organizatsiya")
    private Long idOrganizatsiya;

    @Column(name = "id_tendera")
    private Long idTendera;

    @Column(name = "data_podachi")
    private LocalDateTime dataPodachi;  // Используем LocalDateTime

    @Column(name = "dokument")
    private byte[] usloviyaPdf;

    @Column(name = "id_status_zayavki")
    private Long idStatusZayavki;

    @ManyToOne
    @JoinColumn(name = "id_status_zayavki", referencedColumnName = "id_status_zayavki", insertable = false, updatable = false)
    private StatusZayavki statusZayavki;

    @Column(name = "data_izmeneniya_statusa")
    private LocalDate dataIzmeneniyaStatusa;

    // Getters и Setters
    public StatusZayavki getStatusZayavki() {
        return statusZayavki;
    }

    public void setStatusZayavki(StatusZayavki statusZayavki) {
        this.statusZayavki = statusZayavki;
    }

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

    public LocalDateTime getDataPodachi() {
        return dataPodachi;
    }

    public void setDataPodachi(LocalDateTime dataPodachi) {
        this.dataPodachi = dataPodachi;
    }
    public byte[] getUsloviyaPdf() {
        return usloviyaPdf;
    }

    public void setUsloviyaPdf(byte[] usloviyaPdf) {
        this.usloviyaPdf = usloviyaPdf;
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

    public void setDataIzmeneniyaStatusa(String dataIzmeneniyaStatusa) {
        // Преобразуем строку в LocalDate
        this.dataIzmeneniyaStatusa = LocalDate.parse(dataIzmeneniyaStatusa);
    }
}
