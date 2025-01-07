package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.Tender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface TenderRepository extends JpaRepository<Tender, Long> {
    List<Tender> findAll();


    @Query("SELECT t FROM Tender t WHERE t.nomer LIKE %?1%")
    List<Tender> findByName(String name);
}