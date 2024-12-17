package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.Okved;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OkvedRepository extends JpaRepository<Okved, Long> {
    List<Okved> findAll();
}
