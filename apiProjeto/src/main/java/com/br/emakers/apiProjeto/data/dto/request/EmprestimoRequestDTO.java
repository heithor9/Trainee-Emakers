package com.br.emakers.apiProjeto.data.dto.request;

import com.br.emakers.apiProjeto.data.entity.Livro;
import com.br.emakers.apiProjeto.data.entity.Pessoa;
import jakarta.validation.constraints.NotNull;

public record EmprestimoRequestDTO(
        @NotNull
        Long idPessoa,

        @NotNull
        Long idLivro
) {
}
