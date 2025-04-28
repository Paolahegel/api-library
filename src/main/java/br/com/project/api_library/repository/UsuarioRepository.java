package br.com.project.api_library.repository;

import br.com.project.api_library.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(@NotBlank(message = "E-mail é obrigatório") @Email(message = "E-mail inválido") String email);
}
