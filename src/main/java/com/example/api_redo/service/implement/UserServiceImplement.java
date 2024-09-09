package com.example.api_redo.service.implement;

import com.example.api_redo.entity.UserEntity;
import com.example.api_redo.repository.RoleRepository;
import com.example.api_redo.repository.UserRepository;
import com.example.api_redo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImplement(UserRepository userRepository, RoleRepository roleRepository,  PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }



    @Override
    public List<UserEntity> find_all_users(){
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> find_by_id(Long user_id){
        return userRepository.findById(user_id);
    }



    public boolean roleExists(String roleName) {
        return roleRepository.findById(roleName).isPresent();
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }


    @Override
    public UserEntity save_user(UserEntity userEntity){
        String encodedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodedPassword);
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update_user(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity delete_user(Long user_id){
        userRepository.deleteById(user_id);
        return null;
    }

}
