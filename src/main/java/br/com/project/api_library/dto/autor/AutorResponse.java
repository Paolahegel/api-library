package br.com.project.api_library.dto.autor;

import br.com.project.api_library.dto.livro.LivroResponse;
import br.com.project.api_library.model.Autor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AutorResponse {
    private Long id;
    private String nome;
    private String biografia;
    private List<LivroResponse> livros;

    public AutorResponse(){}

    public static AutorResponse fromEntity(Autor autor){
        AutorResponse dto = new AutorResponse();
        dto.setId(autor.getId());
        dto.setNome(autor.getNome());
        dto.setBiografia(autor.getBiografia());
        dto.setLivros(autor.getLivros().stream()
                .map(LivroResponse::fromEntity)
                .collect(Collectors.toList()));
        return dto;
    }
}
