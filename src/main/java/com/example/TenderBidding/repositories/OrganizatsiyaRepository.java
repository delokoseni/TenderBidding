package com.example.TenderBidding.repositories;

import com.example.TenderBidding.models.Organizatsiya;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface OrganizatsiyaRepository extends JpaRepository<Organizatsiya, Long> {
    Optional<Organizatsiya> findByEmail(String email);
    Optional<Organizatsiya> findByInn(String inn);
    /**
     * Использование @Query, скорее всего, является плохой практикой, но иначе проблему решить не вышло.
     * Дело в том, что Spring Data JPA использует Camel Case, и не видит символ "_".
     * Из-за этого в коде не получается указать название столбца из БД так, чтобы он корректно интерпритировался.
     * @param ogrn_ogrnip
     * @return
     */
    @Query("SELECT o FROM Organizatsiya o WHERE o.ogrn_ogrnip = ?1")
    Optional<Organizatsiya> findByOgrn_ogrnip(String ogrn_ogrnip);

    Optional<Organizatsiya> findByEmailConfirmationToken(String token);
}
