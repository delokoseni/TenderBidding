package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.models.OrganizatsiyaOkved;
import com.example.TenderBidding.models.OrganizatsiyaOkvedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizatsiyaOkvedRepository extends JpaRepository<OrganizatsiyaOkved, OrganizatsiyaOkvedId> {
    List<OrganizatsiyaOkved> findByOrganizatsiya(Organizatsiya organizatsiya);
}
