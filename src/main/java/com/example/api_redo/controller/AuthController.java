package com.example.api_redo.controller;

import com.example.api_redo.auth.JwtUtil;
import com.example.api_redo.entity.UserEntity;
import com.example.api_redo.model.request.LoginReq;
import com.example.api_redo.model.response.ErrorRes;
import com.example.api_redo.model.response.LoginRes;
import com.example.api_redo.repository.UserRepository;
import com.example.api_redo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    public AuthController(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, UserRepository userRepository, AuthenticationManager authenticationManager, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq loginReq) {
        try {
            String email= loginReq.getEmail();
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, loginReq.getPassword()));
            Optional<UserEntity> userOptional = userRepository.findByEmail(email);

            if (userOptional.isPresent()) {
                UserEntity user = userOptional.get();

                if (passwordEncoder.matches(loginReq.getPassword(), user.getPassword())) {

                    String token = jwtUtil.createToken(user);
                    String roleName = user.getRoleName();

                    LoginRes loginRes = new LoginRes(email,token,roleName);

                    return ResponseEntity.ok(loginRes);

                } else {

                    throw new Exception("Invalid username or password");
                }
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            ErrorRes errorRes = new ErrorRes(HttpStatus.UNAUTHORIZED, e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorRes);
        }
    }



    @PostMapping("/register")
    public UserEntity save_users(@RequestBody UserEntity userEntity){

        String roleName = userEntity.getRoleName();

        userEntity.setRoleName(roleName);
        return userService.save_user(userEntity);
    }

}