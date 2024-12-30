package com.br.emakers.apiProjeto.data.entity;
import com.br.emakers.apiProjeto.data.dto.request.LivroRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "autor", nullable = false, length = 45)
    private String autor;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

    @ManyToOne
    @JoinColumn(name = "idLivro")
    private Pessoa pessoa;

    @Builder
    public Livro(LivroRequestDTO livroRequestDTO) {
        this.nome = livroRequestDTO.nome();
        this.autor = livroRequestDTO.autor();
        this.dataPublicacao = livroRequestDTO.data_publicacao();
    }


}
