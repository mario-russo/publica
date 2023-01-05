package br.com.russomario.publica.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.UsuarioRespostaDTO;
import br.com.russomario.publica.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {
    @Mock
    private UsuarioRepository repository;
    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;
    
    UsuarioRequestDTO usuarioRequestDTO;
    UsuarioRespostaDTO usuarioRespostaDTO;
    Optional<Usuario> usuario;
    
    
    @BeforeEach
    void inicio(){
        usuario.    }
    @Test
    void testBuscaId() {
        when(repository.findById(anyLong())).thenReturn(Optional<usuario> );
    }

    @Test
    void testListaTodos() {

    }

    @Test
    void testSalvar() {

    }

    @Test
    void testUsuarioEntity() {

    }
}
