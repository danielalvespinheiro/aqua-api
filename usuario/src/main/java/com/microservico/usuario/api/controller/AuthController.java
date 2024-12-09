package com.microservico.usuario.api.controller;

import com.microservico.usuario.api.model.AuthenticationDTO;
import com.microservico.usuario.domain.service.Impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

@Autowired
private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto){
        return ResponseEntity.ok(authService.login(authDto));
    }
}
