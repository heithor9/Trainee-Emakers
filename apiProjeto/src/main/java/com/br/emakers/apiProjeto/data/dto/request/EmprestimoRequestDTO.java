package com.br.emakers.apiProjeto.data.dto.request;

import com.br.emakers.apiProjeto.data.entity.Livro;
import com.br.emakers.apiProjeto.data.entity.Pessoa;

public record EmprestimoRequestDTO(
        Long idPessoa,

        Long idLivro
) {

}
