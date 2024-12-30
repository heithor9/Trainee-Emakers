package com.br.emakers.apiProjeto.data.dto.response;

import com.br.emakers.apiProjeto.data.entity.Pessoa;

public record PessoaResponseDTO(

        Long idPessoa,

        String nome,

        String cep
) {
    public PessoaResponseDTO(Pessoa pessoa) {
        this(pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCep());
    }
}
