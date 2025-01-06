package com.br.emakers.apiProjeto.controller;

import com.br.emakers.apiProjeto.data.dto.request.LivroRequestDTO;
import com.br.emakers.apiProjeto.data.dto.response.LivroResponseDTO;
import com.br.emakers.apiProjeto.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Buscar todos os livros
    @GetMapping(value = "/all")
    public ResponseEntity<List<LivroResponseDTO>> buscarTodosOsLivros() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarTodasOsLivros());
    }

    // Buscar livro por ID
    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<LivroResponseDTO> buscarLivroPorId(@PathVariable Long idLivro) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.buscarLivroPorId(idLivro));
    }

    // Adicionar novo livro
    @PostMapping(value = "/create")
    public ResponseEntity<LivroResponseDTO> adicionarNovoLivro(@Valid @RequestBody LivroRequestDTO livroRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.adicionarNovoLivro(livroRequestDTO));
    }

    // Atualizar livro existente
    @PutMapping(value = "/update/{idLivro}")
    public ResponseEntity<LivroResponseDTO> atualizarLivro(@PathVariable Long idLivro, @Valid @RequestBody LivroRequestDTO livroRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.atualizarLivro(idLivro, livroRequestDTO));
    }

    // Deletar livro
    @DeleteMapping(value = "/delete/{idLivro}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long idLivro) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.deletarLivro(idLivro));
    }
}
