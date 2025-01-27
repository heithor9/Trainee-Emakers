package com.br.emakers.apiProjeto.repository;

import com.br.emakers.apiProjeto.data.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository  extends JpaRepository<Usuario, String> {
    UserDetails findByLogin(String login);

}
