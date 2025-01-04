package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.OwnershipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OwnershipTypeRepository extends JpaRepository<OwnershipType, Long> {
    List<OwnershipType> findAll();
    @Query("SELECT ot FROM OwnershipType ot WHERE ot.id_forma_sobstvennnosti = ?1")
    Optional<OwnershipType> findById_forma_sobstvennnosti(Long id_forma_sobstvennnosti);
}
