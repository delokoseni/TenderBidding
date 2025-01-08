package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.StatusZayavkiNaUchastie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusZayavkiNaUchastieRepository extends JpaRepository<StatusZayavkiNaUchastie, Long> {
    List<StatusZayavkiNaUchastie> findAll();
    List<StatusZayavkiNaUchastie>  findById(long id);
}