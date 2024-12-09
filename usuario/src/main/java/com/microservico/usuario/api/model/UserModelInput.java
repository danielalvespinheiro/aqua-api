package com.microservico.usuario.api.model;

import lombok.Data;

@Data
public class UserModelInput {

    private String nome;
    private String email;
    private String password;
}
