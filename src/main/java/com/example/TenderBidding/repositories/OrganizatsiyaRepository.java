package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.Organizatsiya;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OrganizatsiyaRepository extends JpaRepository<Organizatsiya, Long> {
    Optional<Organizatsiya> findByEmail(String email);
}
