package com.br.emakers.apiProjeto.data.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "autor", nullable = false, length = 45)
    private String autor;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;

}
