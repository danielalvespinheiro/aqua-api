package com.microservico.usuario.api.model;

import lombok.Data;

@Data
public class UserModel {

    private Long id;
    private String nome;
    private String email;
    private String password;
}
