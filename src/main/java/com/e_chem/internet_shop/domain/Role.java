package com.e_chem.internet_shop.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    GUEST,
    CLIENT,
    MANAGER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}