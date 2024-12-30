package com.br.emakers.apiProjeto.data.dto.response;

import com.br.emakers.apiProjeto.data.entity.Pessoa;

public record PessoaResponseDTO(

        Long Id,

        String nome,

        String cep
) {
    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.get, )
    }
}
