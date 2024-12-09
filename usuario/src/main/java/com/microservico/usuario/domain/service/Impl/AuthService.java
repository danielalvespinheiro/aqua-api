package com.microservico.usuario.domain.service.Impl;

import com.microservico.usuario.api.model.AcessDTO;
import com.microservico.usuario.api.model.AuthenticationDTO;
import com.microservico.usuario.core.security.jwt.JwtUtils;
import com.microservico.usuario.core.security.jwt.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticatioManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDto) {

        try {
            //Cria mecanismo de credencial para o spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword());

            //Prepara mecanismo para autenticacao
            Authentication authentication = authenticatioManager.authenticate(userAuth);

            //Busca usuario logado
            UserDetailService userAuthenticate = (UserDetailService) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDTO accessDto = new AcessDTO(token);

            return accessDto;

        }catch(BadCredentialsException e) {
            //TODO LOGIN OU SENHA INVALIDO
        }
        return new AcessDTO("Acesso negado");
    }

}
