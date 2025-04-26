package br.com.project.api_library.service;

import br.com.project.api_library.dto.livro.LivroRequest;
import br.com.project.api_library.dto.livro.LivroResponse;
import br.com.project.api_library.exceptions.ResourceNotFoundException;
import br.com.project.api_library.model.Autor;
import br.com.project.api_library.model.Livro;
import br.com.project.api_library.repository.AutorRepository;
import br.com.project.api_library.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    @Transactional
    public LivroResponse criarLivro(LivroRequest dto){
        Autor autor = autorService.buscarPorId(dto.getAutorId());

        Livro livro = dto.toEntity();
        livro.setAutor(autor);

        Livro livroSalvo = livroRepository.save(livro);
        return LivroResponse.fromEntity(livroSalvo);
    }

    public List<LivroResponse> listarPorAno(Integer ano) {
        return livroRepository.findByAnoPublicacao(ano).stream()
                .map(LivroResponse::fromEntity)
                .collect(Collectors.toList());
    }


    protected Livro buscarPorId(Long id){
        return livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));
    }

}
