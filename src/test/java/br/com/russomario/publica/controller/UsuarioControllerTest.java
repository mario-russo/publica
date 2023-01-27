
package br.com.russomario.publica.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.russomario.publica.dominio.Publicacao;
import br.com.russomario.publica.dominio.DTO.request.UsuarioRequestDTO;
import br.com.russomario.publica.dominio.DTO.resposta.UsuarioRespostaDTO;
import br.com.russomario.publica.service.UsuarioServiceImpl;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioServiceImpl service;

    @Test
    void BuscaIdTest_retornaUsuarioDTO_dadoUmId() throws Exception {

        Long id = (long) 1;
        List<Publicacao> publicacao = new ArrayList<Publicacao>();
        var usuario = new UsuarioRespostaDTO(id, "mario", "mario@mario", publicacao);

        when(service.BuscaId(anyLong())).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.get("/usuario/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content()
                        .json("{'id':1,'nome':'mario','email':'mario@mario','publicacao':[]}"));
    }

    @Test
    void ListaTodosTest_listaDeUsuarioRequestDTO() throws Exception {

        Long id = (long) 1;
        Long id_2 = (long) 2;
        List<Publicacao> publicacao = new ArrayList<Publicacao>();

        var usuario = new UsuarioRespostaDTO(id, "mario", "mario@mario", publicacao);
        var usuario2 = new UsuarioRespostaDTO(id_2, "mario", "mario@mario", publicacao);

        List<UsuarioRespostaDTO> listaUsuario = List.of(usuario, usuario2);

        when(service.listaTodos()).thenReturn(listaUsuario);

        mockMvc.perform(MockMvcRequestBuilders.get("/usuario"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().json(
                        "[{'id':1,'nome':'mario','email':'mario@mario','publicacao':[]},{'id':2,'nome':'mario','email':'mario@mario','publicacao':[]}]"));

    }

    @Test
    void SalvaTest_retornaUsuarioRespostaDTO_dadoUmUsuarioRequestDTO() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        var requestDTO = new UsuarioRequestDTO("mario", "mario@mario","senha");
        Long id = (long) 1;
        List<Publicacao> publicacao = new ArrayList<Publicacao>();
        var usuario = new UsuarioRespostaDTO(id, requestDTO.getNome(), requestDTO.getEmail(), publicacao);

        when(service.salvar(requestDTO)).thenReturn(usuario);

        mockMvc.perform(MockMvcRequestBuilders.post("/usuario")
                .content(mapper.writeValueAsString(requestDTO))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }
}
