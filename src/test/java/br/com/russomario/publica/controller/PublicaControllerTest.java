
package br.com.russomario.publica.controller;

import static org.mockito.Mockito.when;

import java.util.List;

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

import br.com.russomario.publica.dominio.Usuario;
import br.com.russomario.publica.dominio.DTO.request.PublicacaoRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.PublicacaoRespostaDTO;
import br.com.russomario.publica.service.PublicacaoServiceImpl;

@WebMvcTest(PublicaController.class)
public class PublicaControllerTest {
    @Autowired  
    private MockMvc mockmvc;

    @MockBean
    PublicacaoServiceImpl service;

    @Test
    void BuscaId_retornaPublicacaoDTO_dadoUmId() throws Exception {

        Usuario usuario = new Usuario("mario", "mario@mario","1234");
        Long id = (long) 1;
        PublicacaoRespostaDTO publicacao = new PublicacaoRespostaDTO(id, "java online", usuario,null,null);

        when(service.buscaId(id)).thenReturn(publicacao);

        mockmvc.perform(MockMvcRequestBuilders.get("/publica/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void ListaTodos_retornaLIstaDePublicacaoDTO() throws Exception {

        Usuario usuario = new Usuario("mario", "mario@mario","senha");
        Long id = (long) 1;
        Long id_2 = (long) 2;
        PublicacaoRespostaDTO publicacao = new PublicacaoRespostaDTO(id, "java online", usuario, null,null);
        PublicacaoRespostaDTO publicacao2 = new PublicacaoRespostaDTO(id_2, "java online", usuario,null,null);

        when(service.buscaTodos()).thenReturn(List.of(publicacao, publicacao2));

        mockmvc.perform(MockMvcRequestBuilders.get("/publica"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void SalvaTest_retornaPublicacaoDTO_dadoUmNovaPublicacao() throws JsonProcessingException, Exception {
        
        ObjectMapper mapper = new ObjectMapper();
        Long idUsuario = (long) 1;
        var publicaçao = new PublicacaoRequestDTO("java Estudos!", idUsuario);
        Usuario usuario = new Usuario("mario", "mario@mario","senha");
        var publicaçaoDTO = new PublicacaoRespostaDTO(idUsuario, "java estudos", usuario,null,null);

        when(service.salvar(publicaçao)).thenReturn(publicaçaoDTO);

        mockmvc.perform(MockMvcRequestBuilders.post("/publica")
                .content(mapper.writeValueAsString(publicaçaoDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }
}
