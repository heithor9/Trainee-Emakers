package com.br.emakers.apiProjeto.service;

import com.br.emakers.apiProjeto.data.dto.request.PessoaRequestDTO;
import com.br.emakers.apiProjeto.data.dto.response.PessoaResponseDTO;
import com.br.emakers.apiProjeto.data.entity.Pessoa;
import com.br.emakers.apiProjeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaResponseDTO> buscarTodasAsPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream().map(PessoaResponseDTO::new).collect((Collectors.toList()));
    }

    public PessoaResponseDTO buscarPessoaPorId(Long idPessoa) {
        return null;
    }

    public PessoaResponseDTO adicionarNovaPessoa(PessoaRequestDTO pessoaResponseDTO) {
        return null;
    }
}
