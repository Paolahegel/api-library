package br.com.project.api_library.dto.emprestimo;

import br.com.project.api_library.model.Emprestimo;
import br.com.project.api_library.model.enums.StatusEmprestimo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoResponse {
    private Long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private StatusEmprestimo status;

    public EmprestimoResponse(){}

    public static EmprestimoResponse fromEntity(Emprestimo emprestimo){
        EmprestimoResponse dto = new EmprestimoResponse();
        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());
        dto.setStatus(emprestimo.getStatus());

        return dto;
    }
}
