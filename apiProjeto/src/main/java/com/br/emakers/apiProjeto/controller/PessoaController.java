package com.br.emakers.apiProjeto.controller;

import com.br.emakers.apiProjeto.data.dto.request.PessoaRequestDTO;
import com.br.emakers.apiProjeto.data.dto.response.PessoaResponseDTO;
import com.br.emakers.apiProjeto.data.entity.Pessoa;
import com.br.emakers.apiProjeto.repository.PessoaRepository;
import com.br.emakers.apiProjeto.service.PessoaService;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PessoaResponseDTO>> buscarTodasAsPessoas() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarTodasAsPessoas());
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> buscarPessoaPorId(@PathVariable Long idPessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaPorId(idPessoa));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PessoaResponseDTO> adicionarNovaPessoa (@Valid @RequestBody PessoaRequestDTO pessoaRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.adicionarNovaPessoa(pessoaRequestDTO));
    }

    @PutMapping(value = "uptade/{idPessoa}")
    public ResponseEntity<PessoaResponseDTO> atualizarPessoa(@PathVariable Long idPessoa,@Valid  @RequestBody PessoaRequestDTO pessoaRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizarPessoa(idPessoa, pessoaRequestDTO));
    }

    @DeleteMapping (value = "/delete/{idPessoa}")
    public ResponseEntity<String> deletarPessoa (@PathVariable Long idPessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.deletarPessoa(idPessoa));
    }

}
