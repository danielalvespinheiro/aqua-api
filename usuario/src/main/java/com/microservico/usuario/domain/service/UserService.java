package com.microservico.usuario.domain.service;

import com.microservico.usuario.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> listar();
    User cadastrar(User user);
    Optional<User> findByEmail(String email);
    void deletar(Long id);
}
