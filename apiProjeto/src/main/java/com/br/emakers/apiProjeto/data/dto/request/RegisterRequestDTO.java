package com.br.emakers.apiProjeto.data.dto.request;

import com.br.emakers.apiProjeto.data.entity.UsuarioRole;

public record RegisterRequestDTO(String login, String password, UsuarioRole role) {
}
