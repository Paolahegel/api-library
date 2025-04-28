package br.com.project.api_library.dto.usuario;

import br.com.project.api_library.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public UsuarioResponse(){}

    public static UsuarioResponse fromEntity(Usuario usuario){
        UsuarioResponse dto = new UsuarioResponse();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());

        return dto;
    }
}
