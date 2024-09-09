package com.example.api_redo.service.implement;

import com.example.api_redo.entity.RoleEntity;
import com.example.api_redo.repository.RoleRepository;
import com.example.api_redo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplement implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImplement (RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleEntity> find_all_roles(){
        return roleRepository.findAll();
    }

    @Override
    public Optional<RoleEntity> findByRoleName(String roleName){
        return roleRepository.findById(roleName);
    }

    public boolean roleExists(String roleName) {
        return roleRepository.findById(roleName).isPresent();
    }

    @Override
    public RoleEntity save_role(RoleEntity roleEntity){
        return roleRepository.save(roleEntity);
    }

    @Override
    public RoleEntity update_role(RoleEntity roleEntity){
        return roleRepository.save(roleEntity);
    }

    @Override
    public RoleEntity delete_role(String role_name){
        roleRepository.deleteById(role_name);
        return null;
    }

}
