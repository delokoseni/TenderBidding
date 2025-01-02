package com.example.TenderBidding.models;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.Objects;

public class OrganizatsiyaOkvedId implements Serializable {
    @Column(name = "id_okved")
    private Long idOkved; // Идентификатор ОКВЭД
    @Column(name = "id_organizatsiya")
    private Long idOrganizatsiya; // Идентификатор организации

    public OrganizatsiyaOkvedId() {}

    public OrganizatsiyaOkvedId(Long idOkved, Long idOrganizatsiya) {
        this.idOkved = idOkved;
        this.idOrganizatsiya = idOrganizatsiya;
    }

    // Getters and Setters
    public Long getIdOkved() {
        return idOkved;
    }

    public void setIdOkved(Long idOkved) {
        this.idOkved = idOkved;
    }

    public Long getIdOrganizatsiya() {
        return idOrganizatsiya;
    }

    public void setIdOrganizatsiya(Long idOrganizatsiya) {
        this.idOrganizatsiya = idOrganizatsiya;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizatsiyaOkvedId)) return false;
        OrganizatsiyaOkvedId that = (OrganizatsiyaOkvedId) o;
        return Objects.equals(idOkved, that.idOkved) &&
                Objects.equals(idOrganizatsiya, that.idOrganizatsiya);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOkved, idOrganizatsiya);
    }
}
