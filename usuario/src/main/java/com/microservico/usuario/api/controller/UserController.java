package com.microservico.usuario.api.controller;

import com.microservico.usuario.api.mapper.UserModelMapperBack;
import com.microservico.usuario.api.mapper.UserModelMapper;
import com.microservico.usuario.api.model.UserModel;
import com.microservico.usuario.api.model.UserModelInput;
import com.microservico.usuario.domain.model.User;
import com.microservico.usuario.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserModelMapper userModelMapper;

    @Autowired
    private UserModelMapperBack userModelMapperBack;

    @GetMapping("/listar")
    public ResponseEntity<List<User>> listar() {

        return ResponseEntity.status(HttpStatus.OK).body(userService.listar());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UserModel> cadastrar(@RequestBody @Valid UserModelInput userModelInput){
        User user = userModelMapperBack.toModel(userModelInput);
        UserModel userModel = userModelMapper.toModel(userService.cadastrar(user));

        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<User> deletar(@PathVariable("id") Long id, User user) {

        userService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
