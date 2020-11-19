package com.ufms.olx.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ufms.olx.domain.entities.PessoaFisica;
import com.ufms.olx.domain.enums.SituacaoPessoa;
import com.ufms.olx.domain.enums.TipoPessoa;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(PessoaFisicaController.class)
public class PessoaFisicaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    public PessoaFisica criaPessoaFake() {
        return PessoaFisica
            .fisicaBuilder()
            .apelido("Apelido")
            .cpf("21231231212")
            .dataNascimento(LocalDate.now())
            .id(null)
            .idResponsavel(null)
            .nome("Nome 1 Nome")
            .rg("2131231231")
            .situacaoPessoa(SituacaoPessoa.ATIVO)
            .tipoPessoa(TipoPessoa.FISICA)
            .build();
    }

    @Test
    public void teste() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/pessoaFisica"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deveriaCriarUmaPessoaFisica() throws Exception {
        String json = mapper.writeValueAsString(criaPessoaFake());
        System.out.println(json);
        mockMvc.perform(
            MockMvcRequestBuilders
                .post("/pessoaFisica")
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
        );
    }
}
