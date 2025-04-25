package br.com.project.api_library.dto.usuario;

import br.com.project.api_library.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @Pattern(regexp = "^\\+[0-9\\s] {8,20}$", message = "Telefone inválido")
    private String telefone;

    public UsuarioRequest(){}

    public Usuario toEntity(){
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setTelefone(this.telefone);
        return usuario;
    }
}
