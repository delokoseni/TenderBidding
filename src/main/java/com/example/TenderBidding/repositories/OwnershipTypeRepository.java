package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.OwnershipType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnershipTypeRepository extends JpaRepository<OwnershipType, Long> {
    List<OwnershipType> findAll();
}
