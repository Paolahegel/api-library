package br.com.project.api_library.dto.autor;

import br.com.project.api_library.model.Autor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Size(max = 2000, message = "Biografia deve ter até 2000 caracteres")
    private String biografia;

    public AutorRequest(){}

    public Autor toEntity() {
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setBiografia(this.biografia);
        return autor;
    }
}
