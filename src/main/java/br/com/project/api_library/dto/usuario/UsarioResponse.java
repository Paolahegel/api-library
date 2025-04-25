package br.com.project.api_library.dto.usuario;

import br.com.project.api_library.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public UsarioResponse(){}

    public static UsarioResponse fromEntity(Usuario usuario){
        UsarioResponse dto = new UsarioResponse();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());

        return dto;
    }
}
