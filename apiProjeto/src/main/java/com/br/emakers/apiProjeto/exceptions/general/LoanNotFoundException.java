package com.br.emakers.apiProjeto.exceptions.general;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException (Long id){
        super("O empréstimo de ID " + id + " não foi encontrado");
    }
}