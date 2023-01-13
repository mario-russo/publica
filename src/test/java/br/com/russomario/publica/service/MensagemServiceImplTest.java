package br.com.russomario.publica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.russomario.publica.dominio.Mensagem;
import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.MensagemRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.MensagemRespostaDTO;
import br.com.russomario.publica.repository.MensagemRepository;

@ExtendWith(MockitoExtension.class)
public class MensagemServiceImplTest {

    @Mock
    MensagemRepository repository;

    @Mock
    PublicacaoServiceImpl publicacaoService;

    @Mock
    UsuarioServiceImpl usuarioService;
    @InjectMocks
    MensagemServiceIml service;

    @BeforeEach
    void inicio() {
        MockitoAnnotations.openMocks(this);
        service = new MensagemServiceIml(repository, publicacaoService, usuarioService);

    }

    @Test
    void SalvaMensagem_retornaMensagemDTO_dadoUmaMensagemDTO() {
        Usuario usuario = new Usuario("mario", "mario@email");

        MensagemRequestDTO mensagemRequestDTO = new MensagemRequestDTO("Resposta", (long) 1, (long) 1);
        Mensagem mensagem = new Mensagem(mensagemRequestDTO.getConteudo());
        Publicacao publicacao = new Publicacao("java", usuario);

        when(repository.save(any())).thenReturn(mensagem);
        when(publicacaoService.getPublicacao(anyLong())).thenReturn(publicacao);

        MensagemRespostaDTO resposta = service.salvar(mensagemRequestDTO);

        assertEquals("Resposta", resposta.getConteudo());
        assertEquals(MensagemRespostaDTO.class, resposta.getClass());

    }

    @Test
    void ListaTodasMensagem_retornaMensagemDTO() {

        Mensagem mensagem = new Mensagem("otimo");
        Mensagem mensagem2 = new Mensagem("muito bom");

        when(repository.findAll()).thenReturn(List.of(mensagem, mensagem2));
        List<MensagemRespostaDTO> resposta = service.listaTodos();

        assertEquals(mensagem.getConteudo(), resposta.get(0).getConteudo());
        assertEquals(2, resposta.size());

    }

}
