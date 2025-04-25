package br.com.project.api_library.service;

import br.com.project.api_library.dto.autor.AutorRequest;
import br.com.project.api_library.dto.autor.AutorResponse;
import br.com.project.api_library.exceptions.ResourceNotFoundException;
import br.com.project.api_library.model.Autor;
import br.com.project.api_library.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutorService {

     private final AutorRepository autorRepository;

     public AutorResponse criarAutor(AutorRequest dto){
         Autor autor = dto.toEntity();
         Autor autorSalvo = autorRepository.save(autor);
         return AutorResponse.fromEntity(autorSalvo);
     }

     public Page<AutorResponse> listarAutores(Pageable pageable){
         return autorRepository.findAll(pageable)
                 .map(AutorResponse::fromEntity);

     }

     public AutorResponse buscarPorId(Long id){
         return autorRepository.findById(id)
                 .map(AutorResponse::fromEntity)
                 .orElseThrow(() -> new ResourceNotFoundException("Autor não enontrado"));
     }

     public void excluirAutor(Long id) {
         if(!autorRepository.existsById(id)){
            throw new ResourceNotFoundException("Autor não encontrado");
         }
         autorRepository.deleteById(id);
     }
}
