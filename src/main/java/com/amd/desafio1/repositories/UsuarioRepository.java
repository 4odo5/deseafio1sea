package com.amd.desafio1.repositories;

import com.amd.desafio1.entities.Usuario;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UsuarioRepository extends Repository<Usuario, Long> {
    Optional<Usuario> findByUsr(String usr);
}
