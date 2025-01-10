package com.br.emakers.apiProjeto.service;

import com.br.emakers.apiProjeto.data.dto.request.LivroRequestDTO;
import com.br.emakers.apiProjeto.data.dto.response.LivroResponseDTO;
import com.br.emakers.apiProjeto.data.entity.Livro;
import com.br.emakers.apiProjeto.exceptions.general.EntityNotFoundException;
import com.br.emakers.apiProjeto.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    // Buscar todos os livros
    public List<LivroResponseDTO> buscarTodasOsLivros() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(LivroResponseDTO::new).collect(Collectors.toList());
    }

    // Buscar livro por ID
    public LivroResponseDTO buscarLivroPorId(Long idLivro) {
        Livro livro = buscarLivroPeloId(idLivro);
        return new LivroResponseDTO(livro);
    }

    // Adicionar novo livro
    public LivroResponseDTO adicionarNovoLivro(LivroRequestDTO livroRequestDTO) {
        Livro livro = new Livro(livroRequestDTO);
        livroRepository.save(livro);
        return new LivroResponseDTO(livro);
    }

    // Atualizar livro existente
    public LivroResponseDTO atualizarLivro(Long idLivro, LivroRequestDTO livroRequestDTO) {
        Livro livro = buscarLivroPeloId(idLivro);

        livro.setNome(livroRequestDTO.nome());
        livro.setAutor(livroRequestDTO.autor());
        livro.setDataPublicacao(livroRequestDTO.data_publicacao());
        livro.setDisponivel(livroRequestDTO.disponivel());
        livroRepository.save(livro);

        return new LivroResponseDTO(livro);
    }

    // Deletar livro
    public String deletarLivro(Long idLivro) {
        Livro livro = buscarLivroPeloId(idLivro);
        livroRepository.delete(livro);
        return "Livro ID: " + idLivro + " deletado!";
    }

    // Método privado para buscar livro pelo ID
    private Livro buscarLivroPeloId(Long idLivro) {
        return livroRepository.findById(idLivro).orElseThrow(() -> new EntityNotFoundException(idLivro));
    }
}
