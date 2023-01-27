package br.com.russomario.publica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    Usuario usuario;

    @BeforeEach
    void inicio() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario("mario", "mario@email");
        usuarioServiceImpl = new UsuarioServiceImpl(repository);

        usuarioRequestDTO = new UsuarioRequestDTO(usuario.getNome(), usuario.getEmail(),"1234");
        usuarioRespostaDTO = new UsuarioRespostaDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(),
                usuario.getPublicacao());
    }

    @DisplayName("Deve retorna o um quando for passado um id")
    @Test
    void BuscaIdTeste_retornaUsuario_dadoUmId() throws Exception {

        Optional<Usuario> usuarioOptional;
        usuarioOptional = Optional.of(usuario);

        when(repository.findById((long) 1)).thenReturn(usuarioOptional);
        var reposta = usuarioServiceImpl.BuscaId((long) 1);

        assertEquals(UsuarioRespostaDTO.class, reposta.getClass());
        assertEquals(usuario.getEmail(), reposta.getEmail());
        assertEquals(usuario.getNome(), reposta.getNome());

    }

    @DisplayName("Deve Listar todos Usuários")
    @Test
    void ListaTodosTest_retornaListaDeUsuarios() {

        List<UsuarioRespostaDTO> usuarioRespostaDTOs;

        when(repository.findAll()).thenReturn(List.of(usuario));

        usuarioRespostaDTOs = usuarioServiceImpl.listaTodos();

        assertEquals(UsuarioRespostaDTO.class, usuarioRespostaDTOs.get(0).getClass());
        assertEquals(usuario.getEmail(), usuarioRespostaDTOs.get(0).getEmail());
        assertEquals(usuario.getNome(), usuarioRespostaDTOs.get(0).getNome());

        verify(repository).findAll();

    }

    @DisplayName("Deve salvar o Usuario com sucesso")
    @Test
    void SalvarTeste_retornaUmUsuario_dadoUmUsuarioDTO() throws Exception {

        when(repository.save(any())).thenReturn(usuario);

        usuarioRespostaDTO = usuarioServiceImpl.salvar(usuarioRequestDTO);

        
        verify(repository).save(ArgumentMatchers.any());
        
        assertEquals(UsuarioRespostaDTO.class, usuarioRespostaDTO.getClass());
        assertEquals("mario", usuarioRespostaDTO.getNome());
        assertEquals("mario@email", usuarioRespostaDTO.getEmail());
        }

    @DisplayName("Deve retorna uma mensagem de erro quando o objeto é null")
    @Test
    void ExceptionAoSalvarTeste_retornaUmaMensagemDeErro_dadoUmUsuariNullo() throws Exception{

        when(repository.save(any())).thenReturn(null);

        assertThrowsExactly(Exception.class,()-> usuarioServiceImpl.salvar(usuarioRequestDTO), "Erro o Salva Usuário");
    }

    @DisplayName("Deve retorna uma Entidade de usuario")
    @Test
    void testUsuarioEntity_retornaUmaEntidadeDeUsuario() {
        Optional<Usuario> usuarioOptional;
        usuarioOptional = Optional.of(usuario);

        when(repository.findById(anyLong())).thenReturn(usuarioOptional);

        var reposta = usuarioServiceImpl.usuarioEntity(anyLong());

        assertEquals(Usuario.class, reposta.getClass());
    }
}
