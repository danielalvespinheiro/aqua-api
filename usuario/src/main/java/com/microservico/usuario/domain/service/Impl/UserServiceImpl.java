package com.microservico.usuario.domain.service.Impl;

import com.microservico.usuario.domain.model.User;
import com.microservico.usuario.domain.repository.UserRepository;
import com.microservico.usuario.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> listar() {
        return userRepository.findAll();
    }

    @Override
    public User cadastrar(User user) {
        // Criptografa a senha antes de salvar
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Salva o usuário no banco
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deletar(Long id) {
        userRepository.deleteById(id);
    }
}
