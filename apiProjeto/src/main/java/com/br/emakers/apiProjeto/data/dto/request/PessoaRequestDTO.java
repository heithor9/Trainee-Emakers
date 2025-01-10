package com.br.emakers.apiProjeto.data.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaRequestDTO(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @Size(min = 8, max = 8, message = "O CEP deve ter exatamente 8 caracteres.")
        @NotBlank(message = "O CEP é obrigatório.")
        String cep
) {
}
