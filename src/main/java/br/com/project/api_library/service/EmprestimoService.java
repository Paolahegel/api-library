package br.com.project.api_library.service;

import br.com.project.api_library.dto.emprestimo.EmprestimoRequest;
import br.com.project.api_library.dto.emprestimo.EmprestimoResponse;
import br.com.project.api_library.model.Emprestimo;
import br.com.project.api_library.model.Livro;
import br.com.project.api_library.model.Usuario;
import br.com.project.api_library.model.enums.StatusEmprestimo;
import br.com.project.api_library.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioService usuarioService;
    private final LivroService livroService;

    public EmprestimoResponse realizarEmprestimo(EmprestimoRequest dto){
        Livro livro = livroService.buscarEntidadePorId(dto.getLivroId());
        Usuario usuario = usuarioService.buscarEntidadePorId(dto.getUsuarioId());

        // TODO criar métodos de validações de dipsonibilidade

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setStatus(StatusEmprestimo.ATIVO);

        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);
        return EmprestimoResponse.fromEntity(emprestimoSalvo);
    }

}
