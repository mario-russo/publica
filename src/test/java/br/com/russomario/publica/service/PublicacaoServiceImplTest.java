package br.com.russomario.publica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.PublicacaoRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.PublicacaoRespostaDTO;
import br.com.russomario.publica.repository.PublicacaoRepository;

@ExtendWith(MockitoExtension.class)
public class PublicacaoServiceImplTest {

    @Mock
    private PublicacaoRepository repository;

    @Mock
    UsuarioServiceImpl usuarioService;
    @Mock
    ReacoesServiceImpl reacoesServiceImpl;

    @InjectMocks
    private PublicacaoServiceImpl publicacaoServiceImpl;

    private Publicacao publicacao;
    private PublicacaoRequestDTO publicacaoRequestDTO;
    private Usuario usuario;

    @BeforeEach
    void inicio() {
        MockitoAnnotations.openMocks(this);

        publicacaoServiceImpl = new PublicacaoServiceImpl(repository, usuarioService);

        usuario = new Usuario("mario", "mario@email");

    }

    @DisplayName("Deve retorna uma publicação quando passar um id")
    @Test
    void BuscaIdTeste_retornaUmaPublicacao_dadoUmId() {

        publicacao = new Publicacao("API Spring", usuario);

        Optional<Publicacao> publicacaoOptional;
        publicacaoOptional = Optional.of(publicacao);

        when(repository.findById(anyLong())).thenReturn(publicacaoOptional);

        var reposta = publicacaoServiceImpl.buscaId(anyLong());

        assertEquals(PublicacaoRespostaDTO.class, reposta.getClass());

        verify(repository).findById(anyLong());
    }

    @DisplayName("Deve Retorna Uma Lista De Publicação")
    @Test
    void BuscaTodosTeste_retornaUmaListaDepublicacao() {
        publicacao = new Publicacao("API Spring", usuario);

        when(repository.findAll()).thenReturn(List.of(publicacao));

        var resposta = publicacaoServiceImpl.buscaTodos();

        verify(repository).findAll();

        assertEquals(PublicacaoRespostaDTO.class, resposta.get(0).getClass());

    }

    @DisplayName("deve salvar uma Publicação")
    @Test
    void SalvarTeste_retornaUmaPublicacaoSalva_dadoUmaPublicacaoDTO() {

        publicacaoRequestDTO = new PublicacaoRequestDTO("Api", (long) 1);
        publicacao = new Publicacao(publicacaoRequestDTO.getDescricao(), usuario);

        when(usuarioService.usuarioEntity(anyLong())).thenReturn(usuario);
        when(repository.save(publicacao)).thenReturn(publicacao);

        var resposta = publicacaoServiceImpl.salvar(publicacaoRequestDTO);

        verify(usuarioService).usuarioEntity(anyLong());
        verify(repository).save(any());

        assertEquals(PublicacaoRespostaDTO.class, resposta.getClass());

    }
}
