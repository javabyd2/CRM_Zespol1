package com.example.crm_system.service;


import java.util.HashSet;
import java.util.Set;

import com.example.crm_system.model.User;
import com.example.crm_system.model.Role;
import com.example.crm_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        convertAuthorities(user.getRoles()));
        return userDetails;
    }

    private Set<GrantedAuthority> convertAuthorities(Set<Role> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role ur: userRoles) {
            authorities.add(new SimpleGrantedAuthority(ur.getRole()));
        }
        return authorities;
    }
}