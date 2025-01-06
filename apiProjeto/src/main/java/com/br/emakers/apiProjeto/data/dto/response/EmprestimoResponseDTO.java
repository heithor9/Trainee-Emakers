package com.br.emakers.apiProjeto.data.dto.response;

import com.br.emakers.apiProjeto.data.entity.Emprestimo;
import com.br.emakers.apiProjeto.data.entity.Livro;
import com.br.emakers.apiProjeto.data.entity.Pessoa;

import java.time.LocalDate;

public record EmprestimoResponseDTO(
        Long idEmprestimo,

        Pessoa pessoa,

        Livro livro,

        LocalDate data_emprestimo,

        LocalDate data_devolucao
) {
    public EmprestimoResponseDTO(Emprestimo emprestimo) {
        this(emprestimo.getIdEmprestimo(), emprestimo.getPessoa(),emprestimo.getLivro(), emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao());
    }
}
