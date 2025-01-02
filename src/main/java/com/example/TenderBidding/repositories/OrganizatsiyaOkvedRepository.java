package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.OrganizatsiyaOkved;
import com.example.TenderBidding.models.OrganizatsiyaOkvedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizatsiyaOkvedRepository extends JpaRepository<OrganizatsiyaOkved, OrganizatsiyaOkvedId> {
    // Здесь вы можете добавить дополнительные методы, если это необходимо
}
