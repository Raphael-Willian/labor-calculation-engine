package com.engine.calculator.services;

import com.engine.calculator.models.CustomUserDetails;
import com.engine.calculator.models.User;
import com.engine.calculator.repositorys.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailUser(email).orElseThrow(() -> new UsernameNotFoundException("Usuário" +
                " com o email: " + email + " não foi encontrado."));

        return new CustomUserDetails(user);
    }
}

