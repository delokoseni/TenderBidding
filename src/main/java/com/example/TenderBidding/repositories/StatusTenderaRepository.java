package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.StatusTendera;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface StatusTenderaRepository extends JpaRepository<StatusTendera, Long> {
    List<StatusTendera> findAll();
    List<StatusTendera>  findById(long id);
}