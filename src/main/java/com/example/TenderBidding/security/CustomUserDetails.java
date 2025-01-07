package com.example.TenderBidding.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private final Long organizationId; // Поле для хранения ID организации

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, Long organizationId) {
        super(username, password, authorities);
        this.organizationId = organizationId;
    }

    public Long getOrganizationId() {
        return organizationId; // Метод для получения ID организации
    }
}
