package com.example.TenderBidding.services;

import com.example.TenderBidding.models.Organizatsiya;
import com.example.TenderBidding.repositories.OrganizatsiyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private OrganizatsiyaRepository organizatsiyaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Organizatsiya> organizatsiya = organizatsiyaRepository.findByEmail(email);
        if (organizatsiya.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Возвращаем объект UserDetails (можете создать собственный класс, если потребуется)
        return new org.springframework.security.core.userdetails.User(
                organizatsiya.get().getEmail(),
                organizatsiya.get().getParol(), // Убедитесь в том, что пароль зашифрован
                true, true, true, true,
                new ArrayList<>()
        );
    }
}
