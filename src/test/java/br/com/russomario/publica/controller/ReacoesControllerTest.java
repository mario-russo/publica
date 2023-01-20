
package br.com.russomario.publica.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.Reacoes;
import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.ReacoesRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.ReacoesRepostaDto;
import br.com.russomario.publica.dominio.enumeracoes.ReacoesType;
import br.com.russomario.publica.service.ReacoesServiceImpl;

@WebMvcTest(ReacoesController.class)
public class ReacoesControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    ReacoesServiceImpl service;

    private Usuario usuario;
    private Publicacao publicacao;
    private Reacoes reacoes;
    ReacoesRepostaDto reacoesRepostaDto;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Deve retorna uma lista de Reacões")
    void ListaTodosTest_retornaUmaListaDeReacoes() throws Exception {

        List<ReacoesRepostaDto> lista = List.of(reacoesRepostaDto);

        when(service.listaTodos()).thenReturn(List.of(reacoesRepostaDto));

        mockmvc.perform(MockMvcRequestBuilders.get("/reacoes"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content()
                        .json(mapper.writeValueAsString(lista)));
    }

    @Test
    @DisplayName("Deve Retornar Reacão Salva")
    void SalvaTeste_RetornaUmaReacaoSalva_DadoUmaReacao() throws JsonProcessingException, Exception {
        ReacoesRequestDTO reacoesRequestDTO = new ReacoesRequestDTO(publicacao.getId(),usuario.getId(),ReacoesType.AMEI);

        when(service.salvar(any())).thenReturn(reacoesRepostaDto);

        mockmvc.perform(MockMvcRequestBuilders.post("/reacoes")
                    .content(mapper.writeValueAsString(reacoesRequestDTO))
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @BeforeEach
    void setup() {
        usuario = new Usuario("mario", "email@email");
        publicacao = new Publicacao("estudando java", usuario);
        reacoes = new Reacoes(publicacao, usuario, ReacoesType.AMEI);
        reacoesRepostaDto = new ReacoesRepostaDto(reacoes);

    }
}
