package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.Okved;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OkvedRepository extends JpaRepository<Okved, Long> {
    List<Okved> findAll();
    Optional<Okved> findByKod(String kod);
}
