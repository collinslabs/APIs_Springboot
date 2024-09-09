package com.example.api_redo.service;


import com.example.api_redo.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService  {
    List<UserEntity> find_all_users();
    Optional<UserEntity> find_by_id(Long user_id);
    UserEntity save_user(UserEntity userEntity);
    UserEntity update_user(UserEntity userEntity);
    UserEntity delete_user(Long user_id);
    boolean emailExists(String email);
    boolean roleExists(String roleName);

}
