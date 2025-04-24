package br.com.project.api_library.dto.livro;

import br.com.project.api_library.model.Livro;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroRequest {
    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @Min(value = 0, message = "Ano inválido")
    private Integer anoPublicacao;

    @NotNull(message = "Autor é obrigatório")
    private Long autorId;

    public LivroRequest(){}

    public Livro toEntity(){
        Livro livro = new Livro();
        livro.setTitulo(this.titulo);
        livro.setAnoPublicacao(this.anoPublicacao);
        return livro;

    }
}
