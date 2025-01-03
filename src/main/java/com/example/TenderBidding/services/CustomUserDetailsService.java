package com.example.TenderBidding.services;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
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

        // Возвращаем объект UserDetails. Пароль будет проверен автоматически Spring Security
        return new org.springframework.security.core.userdetails.User(
                organizatsiya.get().getEmail(),
                organizatsiya.get().getParol(), // Убедитесь, что это хэшированный пароль
                true, true, true, true,
                new ArrayList<>()
        );
    }

}
