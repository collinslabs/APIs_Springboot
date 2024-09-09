package com.example.api_redo.controller;

import com.example.api_redo.entity.UserEntity;
import com.example.api_redo.handler.ResponseHandler;
import com.example.api_redo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> find_all_users(){

        List<UserEntity> get_users = userService.find_all_users();
        return ResponseHandler.generate_response("Users retrieved.", HttpStatus.CREATED, get_users);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<Object>  find_by_id(@PathVariable("user_id") Long user_id){
        UserEntity existing_user = userService.find_by_id(user_id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist."));
        Optional<UserEntity> get_user = userService.find_by_id(user_id);
        return ResponseHandler.generate_response("User retrieved.", HttpStatus.CREATED, get_user);
    }

    @PostMapping
    public ResponseEntity<Object> save_users(@RequestBody UserEntity userEntity){

        String email = userEntity.getEmail();
        if(email == null || userService.emailExists(email)) {
            return ResponseHandler.generate_response("Email already exists.", HttpStatus.BAD_REQUEST, null);
        }

        if (!EMAIL_PATTERN.matcher(userEntity.getEmail()).matches()) {
            return ResponseHandler.generate_response("Invalid email format, please try again.", HttpStatus.BAD_REQUEST, null);
        }

        String roleName = userEntity.getRoleName();
        if(roleName == null || !userService.roleExists(roleName)) {
            return ResponseHandler.generate_response("Invalid role name.", HttpStatus.BAD_REQUEST, null);
        }

        userEntity.setRoleName(roleName);
        UserEntity saved_user = userService.save_user(userEntity);

        return ResponseHandler.generate_response("User saved successfully!", HttpStatus.CREATED, saved_user);

    }

    @PutMapping("/{user_id}")
    public ResponseEntity<Object> update_users(@PathVariable Long user_id, @RequestBody UserEntity userEntity){


        UserEntity existing_user = userService.find_by_id(user_id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist."));


        userEntity.setUserId(user_id);

        UserEntity updated_user = userService.update_user(userEntity);
        return ResponseHandler.generate_response("User has been updated successfully!", HttpStatus.CREATED, updated_user);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Object> delete_users(@PathVariable("user_id") Long user_id){
        UserEntity existing_user = userService.find_by_id(user_id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist."));
        UserEntity delete_user = userService.delete_user(user_id);
        return ResponseHandler.generate_response("User has been deleted.", HttpStatus.CREATED, delete_user);

    }


}
