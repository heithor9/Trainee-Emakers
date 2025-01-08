package com.br.emakers.apiProjeto.service;

import com.br.emakers.apiProjeto.data.dto.request.EmprestimoRequestDTO;
import com.br.emakers.apiProjeto.data.dto.response.EmprestimoResponseDTO;
import com.br.emakers.apiProjeto.data.entity.Emprestimo;
import com.br.emakers.apiProjeto.data.entity.Livro;
import com.br.emakers.apiProjeto.data.entity.Pessoa;
import com.br.emakers.apiProjeto.repository.EmprestimoRepository;
import com.br.emakers.apiProjeto.repository.LivroRepository;
import com.br.emakers.apiProjeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;



@Service
public class EmprestimoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoResponseDTO realizarEmprestimo(EmprestimoRequestDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(dto.idPessoa())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + dto.idPessoa()));

        Livro livro = livroRepository.findById(dto.idLivro())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com ID: " + dto.idLivro()));

        if (livro.isDisponivel()) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setPessoa(pessoa);
        livro.setDisponivel(false);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now()); // Adiciona a data atual

        emprestimoRepository.save(emprestimo);

        return new EmprestimoResponseDTO(emprestimo); }

        else
            return null;
    }

    public EmprestimoResponseDTO realizarDevolucao(Long idEmprestimo) {
        Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo)
                .orElseThrow(() -> new RuntimeException("Emprestimo não encontrado com ID: " + idEmprestimo));

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimo.getLivro().setDisponivel(true);

        // Salva a alteração na disponibilidade do livro
        livroRepository.save(emprestimo.getLivro());

        // Retorna a resposta
        return new EmprestimoResponseDTO(emprestimo);
    }


}





/*
    public void devolverLivro(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        Livro livro = emprestimo.getLivro();
        livro.setDisponivel(true);
        livroRepository.save(livro);

        emprestimo.setDataDevolucao(LocalDate.now());
        emprestimoRepository.save(emprestimo);
    }
*/



