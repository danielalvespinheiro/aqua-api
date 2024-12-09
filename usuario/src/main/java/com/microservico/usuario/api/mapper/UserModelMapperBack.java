package com.microservico.usuario.api.mapper;

import com.microservico.usuario.api.model.UserModelInput;
import com.microservico.usuario.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapperBack {

    @Autowired
    private ModelMapper modelMapper;

    public User toModel(UserModelInput userModelInput) {
        return modelMapper.map(userModelInput, User.class);
    }
}
