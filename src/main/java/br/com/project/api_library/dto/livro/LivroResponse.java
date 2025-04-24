package br.com.project.api_library.dto.livro;


import br.com.project.api_library.model.Autor;
import br.com.project.api_library.model.Livro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroResponse {
    private Long id;
    private  String titulo;
    private Integer anoPublicacao;
    private Autor autor;

    public static LivroResponse fromEntity(Livro livro) {
        LivroResponse dto = new LivroResponse();
        dto.setId(livro.getId());
        dto.setTitulo(livro.getTitulo());
        dto.setAnoPublicacao(livro.getAnoPublicacao());
        dto.setAutor(livro.getAutor());

        return dto;
    }

}
