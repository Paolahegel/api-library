package br.com.project.api_library.repository;

import br.com.project.api_library.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Long> {
    List<Livro> anoPublicacao(Integer anoPublicacao);

    @Query("SELECT l FROM Livro l WHERE l.autor.id = :autorId")
    List<Livro> buscarPorAutor(@Param("autorId") Long autorId);
}

