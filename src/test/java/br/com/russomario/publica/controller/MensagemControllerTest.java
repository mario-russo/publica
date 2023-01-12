
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

import br.com.russomario.publica.dominio.DTO.request.MensagemRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.MensagemRespostaDTO;
import br.com.russomario.publica.service.MensagemServiceIml;

@WebMvcTest(MensagemController.class)
public class MensagemControllerTest {

    @MockBean
    private MensagemServiceIml mensagemService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void salvarMensagem_retornaMensagemDTO_dadoMensagemDTO() throws JsonProcessingException, Exception {
        ObjectMapper mapper = new ObjectMapper();
        Long id = (long) 1;
        MensagemRespostaDTO mensagemRespostaDTO = new MensagemRespostaDTO("falando de java", id);
        MensagemRequestDTO mensagemRequestDTO = new MensagemRequestDTO("falando de java");

        when(mensagemService.salvar(mensagemRequestDTO)).thenReturn(mensagemRespostaDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/mensagem")
                .content(mapper.writeValueAsString(mensagemRequestDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    @Test
    void listaTodos_retornaListaDeMensagemDTO() throws Exception{

        Long id = (long) 1;
        MensagemRespostaDTO mensagemRespostaDTO = new MensagemRespostaDTO("falando de java", id);

        when(mensagemService.listaTodos()).thenReturn(List.of(mensagemRespostaDTO));

        mockMvc.perform(MockMvcRequestBuilders.get("/mensagem"))
            .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json("[{'conteudo':'falando de java','id':1}]"));
    }

}
