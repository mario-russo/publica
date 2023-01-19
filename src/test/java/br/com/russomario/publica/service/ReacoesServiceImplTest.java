package br.com.russomario.publica.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Reacoes;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.ReacoesRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.ReacoesRepostaDto;
import br.com.russomario.publica.dominio.enumeracoes.ReacoesType;
import br.com.russomario.publica.repository.ReacoesRepository;

@ExtendWith(MockitoExtension.class)
public class ReacoesServiceImplTest {

    @Mock
    private ReacoesRepository reacoesRepository;

    @Mock
    private UsuarioServiceImpl usuarioServiceImpl;

    @Mock
    private PublicacaoServiceImpl publicacaoServiceImpl;
    @InjectMocks
    private ReacoesServiceImpl servico;

    private Reacoes reacoes;
    private Usuario usuario;
    private Publicacao publicacao;
    private ReacoesRequestDTO reacoesRequestDTO ;
    

    @Test
    void testListaTodos() {

    }

    @Test
    @DisplayName("Deve Salvar uma Reação e retorna um dto")
    void SalvarTeste_retornaDTO_dadoUmaReacao() {
        

        when(usuarioServiceImpl.usuarioEntity(anyLong())).thenReturn(usuario);
        when(publicacaoServiceImpl.getPublicacao(anyLong())).thenReturn(publicacao);
        when(reacoesRepository.save(ArgumentMatchers.any())).thenReturn(reacoes);
        
        var reacoes = servico.salvar(reacoesRequestDTO);

        assertEquals(ReacoesRepostaDto.class, reacoes.getClass());
    }

    @BeforeEach
    void inicio() {
        MockitoAnnotations.openMocks(this);

        servico = new ReacoesServiceImpl(reacoesRepository, usuarioServiceImpl, publicacaoServiceImpl);
        
        reacoes = new Reacoes(publicacao, usuario, ReacoesType.AMEI);
        usuario= new Usuario("mario", "email@email");
        publicacao = new Publicacao("estudando java", usuario);

        reacoesRequestDTO = new ReacoesRequestDTO((long)1, (long) 1, ReacoesType.APOIO);
    }
}
