package com.br.emakers.apiProjeto.service;

import com.br.emakers.apiProjeto.data.dto.request.EmprestimoRequestDTO;
import com.br.emakers.apiProjeto.data.dto.response.EmprestimoResponseDTO;
import com.br.emakers.apiProjeto.data.entity.Emprestimo;
import com.br.emakers.apiProjeto.data.entity.Livro;
import com.br.emakers.apiProjeto.data.entity.Pessoa;
import com.br.emakers.apiProjeto.exceptions.general.EntityNotFoundException;
import com.br.emakers.apiProjeto.exceptions.general.LoanNotFoundException;
import com.br.emakers.apiProjeto.repository.EmprestimoRepository;
import com.br.emakers.apiProjeto.repository.LivroRepository;
import com.br.emakers.apiProjeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;



@Service
public class EmprestimoService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoResponseDTO realizarEmprestimo(EmprestimoRequestDTO emprestimoRequestDTO) {
        // Busca a entidade Pessoa pelo ID
        Pessoa pessoa = pessoaRepository.findById(emprestimoRequestDTO.idPessoa())
                .orElseThrow(() -> new EntityNotFoundException(emprestimoRequestDTO.idPessoa()));

        // Busca a entidade Livro pelo ID
        Livro livro = livroRepository.findById(emprestimoRequestDTO.idLivro())
                .orElseThrow(() -> new EntityNotFoundException(emprestimoRequestDTO.idLivro()));

        // Verifica se o livro está disponível
        if (!livro.isDisponivel()) {
            throw new IllegalArgumentException("O livro já está emprestado!");
        }

        // Cria o empréstimo e associa Pessoa e Livro
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setPessoa(pessoa);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now()); // Define a data de empréstimo automaticamente
        emprestimo.setDataDevolucao(null); // Certifica-se de que a data de devolução está nula

        // Atualiza a disponibilidade do livro
        livro.setDisponivel(false);
        livroRepository.save(livro);

        // Salva o empréstimo no repositório
        emprestimoRepository.save(emprestimo);

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
    }*/




