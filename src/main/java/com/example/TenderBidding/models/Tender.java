package com.example.TenderBidding.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tender")
public class Tender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Это предполагает, что вы используете автоинкрементный идентификатор
    private Long id_tendera; // Идентификатор тендера

    private String nomer; // Номер тендера
    private Long id_statusa_tendera; // статус
    private Long id_zayavki_na_provedenie_tendera; // заявка основание
    private LocalDate data_nachala; // Дата начала
    private LocalDate data_okonchaniya; // Дата окончания
    private Double nachalnaya_tsena; // начальная цена
    private byte[] dokument; // Дополнительный документ
    private LocalDate data_izmeneniya_statusa; // Дата изменения статуса
    private Long id_pobeditelya; // Победитель
    private Long id_organizatora; //

    // Getters and Setters
    public Long getId_tendera() {
        return id_tendera;
    }

    public void setId_tendera(Long id_tendera) {
        this.id_tendera = id_tendera;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Long getId_statusa_tendera() {
        return id_statusa_tendera;
    }

    public void setId_statusa_tendera(Long id_statusa_tendera) {
        this.id_statusa_tendera = id_statusa_tendera;
    }

    public Long getId_zayavki_na_provedenie_tendera() {
        return id_zayavki_na_provedenie_tendera;
    }

    public void setId_zayavki_na_provedenie_tendera(Long id_zayavki_na_provedenie_tendera) {
        this.id_zayavki_na_provedenie_tendera = id_zayavki_na_provedenie_tendera;
    }

    public LocalDate getData_nachala() {
        return data_nachala;
    }

    public void setData_nachala(LocalDate data_nachala) {
        this.data_nachala = data_nachala;
    }

    public LocalDate getData_okonchaniya() {
        return data_okonchaniya;
    }

    public void setData_okonchaniya(LocalDate data_okonchaniya) {
        this.data_okonchaniya = data_okonchaniya;
    }

    public Double getNachalnaya_tsena() {
        return nachalnaya_tsena;
    }

    public void setNachalnaya_tsena(Double nachalnaya_tsena) {
        this.nachalnaya_tsena = nachalnaya_tsena;
    }

    public byte[] getDokument() {
        return dokument;
    }

    public void setDokument(byte[] dokument) {
        this.dokument = dokument;
    }

    public LocalDate getData_izmeneniya_statusa() {
        return data_izmeneniya_statusa;
    }

    public void setData_izmeneniya_statusa(LocalDate data_izmeneniya_statusa) {
        this.data_izmeneniya_statusa = data_izmeneniya_statusa;
    }

    public Long getId_pobeditelya() {
        return id_pobeditelya;
    }

    public void setId_pobeditelya(Long id_pobeditelya) {
        this.id_pobeditelya = id_pobeditelya;
    }

    public Long getId_organizatora() {
        return id_organizatora;
    }

    public void setId_organizatora(Long id_organizatora) {
        this.id_organizatora = id_organizatora;
    }



    @Override
    public String toString() {
        return "Tender{" +
                "id_tendera=" + id_tendera +
                ", nomer='" + nomer + '\'' +
                ", id_statusa_tendera=" + id_statusa_tendera +
                ", id_zayavki_na_provedenie_tendera=" + id_zayavki_na_provedenie_tendera +
                ", data_nachala=" + data_nachala +
                ", data_okonchaniya=" + data_okonchaniya +
                ", nachalnaya_tsena=" + nachalnaya_tsena +
                ", dokument='" + dokument + '\'' +
                ", data_izmeneniya_statusa=" + data_izmeneniya_statusa +
                ", id_pobeditelya=" + id_pobeditelya +
                ", id_organizatora=" + id_organizatora +
                '}';
    }
}