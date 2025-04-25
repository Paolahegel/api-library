package br.com.project.api_library.repository;

import br.com.project.api_library.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    @Query("SELECT e FROM Emprestimo e WHERE e.usuario.id = :usuarioId AND e.status = 'ATIVO'")
    List<Emprestimo> buscarEmprestimoAtivosPorUsuario(@Param("usuarioId") Long usuarioId);
}
