package com.example.demoq.UserDetailsService;

import com.example.demoq.model.User;
import com.example.demoq.model.UserDto;
import com.example.demoq.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class UserRegistrationService  {

    PasswordEncoder passwordEncoder;

    public UserRegistrationService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private UserRepository myUserRepository;

    public boolean registerNewUser(UserDto userDto) {

        User user = new User();

        Optional<User> userCheck = myUserRepository.findByUsername(userDto.getUserName());

        if(userCheck.isEmpty()){
        user.setUsername(userDto.getUserName());
        user.setPassword(passwordEncoder
                .encode(userDto.getPassword()));
        user.setRoles("ROLE_USER");
        user.setEmail(userDto.getEmail());
         myUserRepository.save(user);

         return true;
        }else

        return false;
    }


}
