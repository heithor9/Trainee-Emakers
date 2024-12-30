package com.br.emakers.apiProjeto.data.dto.request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.springframework.cglib.core.Local;
import java.time.LocalDate;

public record LivroRequestDTO(
        @NotBlank(message = "O nome do livro é obrigatório.")
        String nome,

        @NotBlank(message = "O nome do autor é obrigatório.")
        String autor,

        @NotNull(message = "A data de publicação é obrigatória.")
        @PastOrPresent(message = "A data de publicação não pode ser no futuro.")
        LocalDate data_publicacao

) {
}
