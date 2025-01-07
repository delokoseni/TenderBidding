package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.ZayavkaNaUchastieVTendere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import java.util.List;

public interface ZayavkaNaUchastieVTendereRepository extends JpaRepository<ZayavkaNaUchastieVTendere, Long> {

    List<ZayavkaNaUchastieVTendere> findByIdOrganizatsiya(Long idOrganizatsiya);

    // Использование запроса для поиска по id
    @Query("SELECT z FROM ZayavkaNaUchastieVTendere z WHERE z.idZayavkiNaUchastieVTendere = ?1")
    Optional<ZayavkaNaUchastieVTendere> findByIdZayavkiNaUchastieVTendere(Long id);

    // Использование запроса для поиска по id Организации и id Тендера
    @Query("SELECT z FROM ZayavkaNaUchastieVTendere z WHERE z.idOrganizatsiya = ?1 AND z.idTendera = ?2")
    Optional<ZayavkaNaUchastieVTendere> findByOrganizatsiyaAndTendera(Long idOrganizatsiya, Long idTendera);
}
