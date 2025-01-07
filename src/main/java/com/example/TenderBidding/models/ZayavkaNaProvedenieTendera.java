package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "zayavka_na_provedenie_tendera")
public class ZayavkaNaProvedenieTendera {
    @Id
    private Long idZayavkiNaProvedenieTendera;

    private String dataNachalaTendera;
    private String dataOkonchaniyaTendera;
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

    public String getDataNachalaTendera() {
        return dataNachalaTendera;
    }

    public void setDataNachalaTendera(String dataNachalaTendera) {
        this.dataNachalaTendera = dataNachalaTendera;
    }

    public String getDataOkonchaniyaTendera() {
        return dataOkonchaniyaTendera;
    }

    public void setDataOkonchaniyaTendera(String dataOkonchaniyaTendera) {
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
