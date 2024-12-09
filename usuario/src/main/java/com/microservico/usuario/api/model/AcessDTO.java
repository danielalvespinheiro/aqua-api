package com.microservico.usuario.api.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AcessDTO {

    private String token;
    private String type = "Bearer";

    public AcessDTO(String token) {
        this.token = token;
    }

    //TODO implementar retornar o usuario e liberacoes (authorities)

}

