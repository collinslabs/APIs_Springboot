package com.example.api_redo.controller;

import com.example.api_redo.entity.RoleEntity;
import com.example.api_redo.entity.UserEntity;
import com.example.api_redo.handler.ResponseHandler;
import com.example.api_redo.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<Object> find_all_roles(){
        List<RoleEntity> get_roles = roleService.find_all_roles();
        return ResponseHandler.generate_response("Roles retrieved.", HttpStatus.CREATED, get_roles);

    }

    @GetMapping("/{roleName}")
    public ResponseEntity<Object> findByRoleName(@PathVariable("roleName") String roleName){
        RoleEntity existing_role = roleService.findByRoleName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role does not exist."));
        Optional<RoleEntity> get_role = roleService.findByRoleName(roleName);
        return ResponseHandler.generate_response("Role retrieved.", HttpStatus.CREATED, get_role);
    }

    @PostMapping
    public ResponseEntity<Object> save_role(@RequestBody RoleEntity roleEntity){
        String role = roleEntity.getRoleName();
        if(role == null || roleService.roleExists(role)){
            return ResponseHandler.generate_response("Role already exists.", HttpStatus.BAD_REQUEST, null);
        }
        RoleEntity saved_role = roleService.save_role(roleEntity);
        return ResponseHandler.generate_response("Role saved successfully!", HttpStatus.CREATED, saved_role);
    }

    @PutMapping("/{roleName}")
    public ResponseEntity<Object> update_role(@PathVariable("roleName") String roleName, @RequestBody RoleEntity roleEntity){
        RoleEntity existing_role = roleService.findByRoleName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role does not exist."));
        roleEntity.setRoleName(roleName);
        RoleEntity updated_role = roleService.update_role(roleEntity);
        return ResponseHandler.generate_response("Role has been updated successfully!", HttpStatus.CREATED, updated_role);

    }

    @DeleteMapping("/{roleName}")
    public ResponseEntity<Object> delete_role(@PathVariable("roleName") String roleName){
        RoleEntity existing_role = roleService.findByRoleName(roleName)
                .orElseThrow(() -> new EntityNotFoundException("Role does not exist."));
        RoleEntity delete_role = roleService.delete_role(roleName);
        return ResponseHandler.generate_response("Role has been deleted.", HttpStatus.CREATED, delete_role);
    }

}
