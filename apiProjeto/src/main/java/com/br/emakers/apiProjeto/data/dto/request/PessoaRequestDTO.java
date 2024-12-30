package com.br.emakers.apiProjeto.data.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaRequestDTO(

        @NotBlank(message = "O nome é obrigatório.")
        String nome,

        @Size(min = 9, max = 9, message = "O CEP deve ter exatamente 9 caracteres.")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 12345-678.")
        @NotBlank(message = "O CEP é obrigatório.")
        String cep
) {
}
