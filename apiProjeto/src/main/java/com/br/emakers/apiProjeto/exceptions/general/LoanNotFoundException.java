package com.br.emakers.apiProjeto.exceptions.general;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException (){
        super("Pessoa ou Livro não encontrado!");
    }
}