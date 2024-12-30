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
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO adicionarNovaPessoa(PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = new Pessoa(pessoaRequestDTO);
        pessoaRepository.save(pessoa);

        return new PessoaResponseDTO(pessoa);
    }

    public PessoaResponseDTO atualizarPessoa(Long idPessoa, PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);

        pessoa.setNome(pessoaRequestDTO.nome());
        pessoa.setCep(pessoaRequestDTO.cep());
        pessoaRepository.save(pessoa);
        return new PessoaResponseDTO(pessoa);
    }

    public String deletePessoa(Long idPessoa){
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);
        pessoaRepository.delete(pessoa);
        return "Pessoa iD: " + idPessoa + " deletada!";
    }

    private Pessoa buscarPessoaPeloId(Long idPessoa) {
        return pessoaRepository.findById(idPessoa).orElseThrow(()-> new RuntimeException("Pessoa não encontrada"));
    }
}
