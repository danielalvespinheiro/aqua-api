package com.microservico.usuario.core.security.jwt;

import com.microservico.usuario.domain.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;

public class UserDetailService implements UserDetails {

    private Long id;

    private String nome;

    private String password;

    private String email;

    public String getEmail() {
        return email;
    }

    public UserDetailService(Long id, String nome, String email, String password,
                             Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailService build(User usuario) {
        return new UserDetailService(
                //atenção na orde desses elementos
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getPassword(),
                new ArrayList<>());
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
