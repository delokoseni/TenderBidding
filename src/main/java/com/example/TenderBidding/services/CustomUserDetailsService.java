package com.example.TenderBidding.services;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import com.example.TenderBidding.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private OrganizatsiyaRepository organizatsiyaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Organizatsiya> organizatsiya = organizatsiyaRepository.findByEmail(username);
        if (organizatsiya.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Создаем объект CustomUserDetails с дополнительным полем organizationId
        CustomUserDetails userDetails = new CustomUserDetails(
                organizatsiya.get().getEmail(),
                organizatsiya.get().getParol(), // Убедитесь, что это хэшированный пароль
                new ArrayList<>(), // Роли и авторизации
                organizatsiya.get().getId_organizatsii() // ID организации
        );

        return userDetails;
    }
}
