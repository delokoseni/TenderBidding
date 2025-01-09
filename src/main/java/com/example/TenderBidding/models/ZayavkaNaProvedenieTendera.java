package com.example.TenderBidding.models;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "zayavka_na_provedenie_tendera")
public class ZayavkaNaProvedenieTendera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idZayavkiNaProvedenieTendera;

    private LocalDate dataNachalaTendera;
    private LocalDate dataOkonchaniyaTendera;
    private Double nachalnayaTsena;
    private Long idOrganizatsii;  // Ссылка на организацию

    @Column(name = "id_status_zayavki", insertable = false, updatable = false)
    private Long idStatusZayavki;

    @ManyToOne
    @JoinColumn(name = "id_status_zayavki", referencedColumnName = "id_status_zayavki")
    private StatusZayavki statusZayavki;

    @Column(name = "dokument")
    private byte[] usloviyaPdf;

    // Getters и Setters
    public StatusZayavki getStatusZayavki() {
        return statusZayavki;
    }

    public void setStatusZayavki(StatusZayavki statusZayavki) {
        this.statusZayavki = statusZayavki;
    }

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

    public void setIdStatusZayavki(Long idStatusZayavki) {
        this.idStatusZayavki = idStatusZayavki;
    }

    public byte[] getUsloviyaPdf() {
        return usloviyaPdf;
    }

    public void setUsloviyaPdf(byte[] usloviyaPdf) {
        this.usloviyaPdf = usloviyaPdf;
    }
}
