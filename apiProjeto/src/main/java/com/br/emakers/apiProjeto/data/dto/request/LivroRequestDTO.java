package com.br.emakers.apiProjeto.data.dto.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.util.Date;


public record LivroRequestDTO(
        @NotBlank(message = "O nome do livro é obrigatório.")
        String nome,

        @NotBlank(message = "O nome do autor é obrigatório.")
        String autor,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
        @NotNull(message = "A data de publicação é obrigatória.")
        @PastOrPresent(message = "A data de publicação não pode ser no futuro.")
        Date data_publicacao

) {
}
