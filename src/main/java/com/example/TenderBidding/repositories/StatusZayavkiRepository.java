package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.StatusZayavki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StatusZayavkiRepository extends JpaRepository<StatusZayavki, Long> {
    Optional<StatusZayavki> findById(Long id);  // Меняем на возвращение Optional
}
