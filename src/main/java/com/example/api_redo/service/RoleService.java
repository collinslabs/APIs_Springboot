package com.example.api_redo.service;

import com.example.api_redo.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleEntity> find_all_roles();
    Optional<RoleEntity> findByRoleName(String roleName);
    RoleEntity save_role(RoleEntity roleEntity);
    RoleEntity update_role(RoleEntity roleEntity);
    RoleEntity delete_role(String role_name);
    boolean roleExists(String roleName);


}
