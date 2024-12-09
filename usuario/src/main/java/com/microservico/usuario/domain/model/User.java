package com.microservico.usuario.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "usuarios")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

}
