package com.example.TenderBidding.models;

import jakarta.persistence.*;

@Entity
@Table(name = "organizatsiya_okved")
public class OrganizatsiyaOkved {

    @EmbeddedId
    private OrganizatsiyaOkvedId id; // Используем составной ключ

    @ManyToOne
    @MapsId("idOkved") // Указывает, что idOkved из составного ключа связано с сущностью Okved
    @JoinColumn(name = "id_okved")
    private Okved okved;

    @ManyToOne
    @MapsId("idOrganizatsiya") // Указывает, что idOrganizatsiya из составного ключа связано с сущностью Organizatsiya
    @JoinColumn(name = "id_organizatsiya")
    private Organizatsiya organizatsiya;

    // Getters and Setters
    public OrganizatsiyaOkvedId getId() {
        return id;
    }

    public void setId(OrganizatsiyaOkvedId id) {
        this.id = id;
    }

    public Okved getOkved() {
        return okved;
    }

    public void setOkved(Okved okved) {
        this.okved = okved;
    }

    public Organizatsiya getOrganizatsiya() {
        return organizatsiya;
    }

    public void setOrganizatsiya(Organizatsiya organizatsiya) {
        this.organizatsiya = organizatsiya;
    }

    @Override
    public String toString() {
        return "OrganizatsiyaOkved{" +
                "id=" + id +
                ", okved=" + okved +
                ", organizatsiya=" + organizatsiya +
                '}';
    }
}
