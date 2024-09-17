package dev.fernando.service;

import dev.fernando.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

    public UserEntity createUser(UserEntity userEntity) {
        if(userEntity.userName == null){
            throw new IllegalArgumentException("Nome do Usuario Obrigatorio");
        }
        if(userEntity.password == null){
            throw new IllegalArgumentException("Senha do Usuario Obrigatorio");
        }

        UserEntity.persist(userEntity);
        return userEntity;
    };

    public UserEntity getUser(UserEntity userEntity){

        if(userEntity.userName == null){
            
        }

        return userEntity;
    };
}
