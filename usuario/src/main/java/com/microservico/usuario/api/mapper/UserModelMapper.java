package com.microservico.usuario.api.mapper;

import com.microservico.usuario.api.model.UserModel;
import com.microservico.usuario.domain.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserModel toModel(User user) {
        UserModel userMatriculaModel =
                modelMapper.map(user, UserModel.class);
        return userMatriculaModel;
    }

}
