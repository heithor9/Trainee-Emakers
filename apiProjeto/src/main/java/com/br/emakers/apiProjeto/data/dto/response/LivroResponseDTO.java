package com.br.emakers.apiProjeto.data.dto.response;

import com.br.emakers.apiProjeto.data.entity.Livro;

import java.sql.Date;
import java.time.LocalDate;

public record LivroResponseDTO(

        Long idLivro,

        String nome,

        String autor,

        Date data_publicacao
) {
    public LivroResponseDTO(Livro livro) {
        this(livro.getIdLivro(), livro.getNome(), livro.getAutor(), livro.getDataPublicacao());
    }
}
