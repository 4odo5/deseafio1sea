package com.amd.desafio1.security;

import com.amd.desafio1.entities.Usuario;
import com.amd.desafio1.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us = usuarioRepository.findByUsr(username).orElseThrow(
                () -> new RuntimeException("DEU RUIM NA AUTENTICACAO")
        );

        return new UserDetailsImpl(us);
    }
}
