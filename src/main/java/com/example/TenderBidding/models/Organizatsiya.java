package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "organizatsiya")
public class Organizatsiya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_organizatsii; // Идентификатор организации

    private String imya; // Наименование организации
    private String inn; // ИНН
    private String ogrn_ogrnip; // ОГРН/ОГРНИП
    private Long id_forma_sobstvennosti; // Идентификатор формы собственности
    private LocalDate data_osnovaniya; // Дата основания
    private String email; // Email
    private String parol; // Пароль

    // Getters and Setters
    public Long getId_organizatsii() {
        return id_organizatsii;
    }

    public void setId_organizatsii(Long id_organizatsii) {
        this.id_organizatsii = id_organizatsii;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOgrn_ogrnip() {
        return ogrn_ogrnip;
    }

    public void setOgrn_ogrnip(String ogrn_ogrnip) {
        this.ogrn_ogrnip = ogrn_ogrnip;
    }

    public Long getId_forma_sobstvennosti() {
        return id_forma_sobstvennosti;
    }

    public void setId_forma_sobstvennosti(Long id_forma_sobstvennosti) {
        this.id_forma_sobstvennosti = id_forma_sobstvennosti;
    }

    public LocalDate getData_osnovaniya() {
        return data_osnovaniya;
    }

    public void setData_osnovaniya(LocalDate data_osnovaniya) {
        this.data_osnovaniya = data_osnovaniya;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    @Override
    public String toString() {
        return "Organizatsiya{" +
                "id_organizatsii=" + id_organizatsii +
                ", imya='" + imya + '\'' +
                ", inn='" + inn + '\'' +
                ", ogrn_ogrnip='" + ogrn_ogrnip + '\'' +
                ", id_forma_sobstvennosti=" + id_forma_sobstvennosti +
                ", data_osnovaniya='" + data_osnovaniya + '\'' +
                ", email='" + email + '\'' +
                ", parol='" + parol + '\'' +
                '}';
    }
}
