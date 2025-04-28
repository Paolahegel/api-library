package br.com.project.api_library.service;

import br.com.project.api_library.dto.usuario.UsuarioRequest;
import br.com.project.api_library.dto.usuario.UsuarioResponse;
import br.com.project.api_library.exceptions.BusinessException;
import br.com.project.api_library.exceptions.ResourceNotFoundException;
import br.com.project.api_library.model.Usuario;
import br.com.project.api_library.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioResponse criarUsuario(UsuarioRequest dto){
        if(usuarioRepository.existsByEmail(dto.getEmail())){
            throw new BusinessException("E-mail já cadastrado!");
        }

        Usuario usuario = dto.toEntity();
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return UsuarioResponse.fromEntity(usuarioSalvo);
    }

    protected Usuario buscarEntidadePorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }
}
