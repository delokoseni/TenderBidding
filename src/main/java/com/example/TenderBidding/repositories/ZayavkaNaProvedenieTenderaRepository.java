package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.ZayavkaNaProvedenieTendera;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ZayavkaNaProvedenieTenderaRepository extends JpaRepository<ZayavkaNaProvedenieTendera, Long> {
    List<ZayavkaNaProvedenieTendera> findByIdOrganizatsii(Long idOrganizatsii);
}

