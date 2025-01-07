package com.br.emakers.apiProjeto.data.entity;

import com.br.emakers.apiProjeto.data.dto.request.PessoaRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "cep", nullable = false, length = 9)
    private String cep;


    @Builder
    public Pessoa(PessoaRequestDTO pessoaRequestDTO) {
        this.nome = pessoaRequestDTO.nome();
        this.cep = pessoaRequestDTO.cep();
    }
}

