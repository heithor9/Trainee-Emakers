package com.br.emakers.apiProjeto.service;

import com.br.emakers.apiProjeto.data.dto.request.PessoaRequestDTO;
import com.br.emakers.apiProjeto.data.dto.response.PessoaResponseDTO;
import com.br.emakers.apiProjeto.data.entity.Pessoa;
import com.br.emakers.apiProjeto.exceptions.general.EntityNotFoundException;
import com.br.emakers.apiProjeto.repository.PessoaRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

    public PessoaResponseDTO adicionarNovaPessoa(PessoaRequestDTO pessoaRequestDTO) throws Exception {
        Pessoa pessoa = new Pessoa(pessoaRequestDTO);

        //** Consumindo API publica externa

        URL url = new URL("https://viacep.com.br/ws/" +pessoa.getCep()+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        String cep = "";
        StringBuilder jsonCep = new StringBuilder();

        while ((cep = br.readLine()) != null) {
            jsonCep.append(cep);
        }

        Pessoa pessoaAux = new Gson().fromJson(jsonCep.toString(), Pessoa.class);

        pessoa.setLogradouro(pessoaAux.getLogradouro());
        pessoa.setBairro(pessoaAux.getBairro());
        pessoa.setUf(pessoaAux.getUf());

        //** Consumindo API publica externa

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

    public String deletarPessoa(Long idPessoa){
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);
        pessoaRepository.delete(pessoa);
        return "Pessoa iD: " + idPessoa + " deletada!";
    }

    private Pessoa buscarPessoaPeloId(Long idPessoa) {
        return pessoaRepository.findById(idPessoa).orElseThrow(()-> new EntityNotFoundException(idPessoa));
    }

}
