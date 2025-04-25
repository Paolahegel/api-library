package br.com.project.api_library.dto.emprestimo;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmprestimoRequest {
    @NotNull(message = "Livro é obrigatório")
    private Long livroId;

    @NotNull(message = "Usuário é obrigatório")
    private Long usuarioId;

    public EmprestimoRequest(){}

}
