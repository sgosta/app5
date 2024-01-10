package it.example.controllers;

import it.example.config.AppConfig;
import it.example.config.Dispatcher;
import it.example.model.Auto;
import it.example.service.AutoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.util.Arrays;

import static java.nio.file.Paths.get;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, Dispatcher.class})
@WebAppConfiguration
public class AutoControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private AutoService autoService;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        Mockito.reset(autoService);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test_IfAddsAndShowsAutos() throws Exception {
        Auto auto1 = new Auto();
        auto1.setMarca("Fiat");
        auto1.setModello("Panda");
        auto1.setCilindrata(1.0);
        auto1.setCavalli(1.0);
        auto1.setCoppia(1.0);
        auto1.setColore("nero");

        Auto auto2 = new Auto();
        auto1.setMarca("Fiat");
        auto1.setModello("Bravo");
        auto1.setCilindrata(1.0);
        auto1.setCavalli(1.0);
        auto1.setCoppia(1.0);
        auto1.setColore("bianco");

        when(autoService.loadAutos()).thenReturn(Arrays.asList(auto1, auto2));

        mockMvc.perform((RequestBuilder)get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("list_auto"))
                .andExpect(forwardedUrl("/WEB-INF/views/list_autos.jsp"))
                .andExpect(model().attribute("autos", hasSize(2)))
                .andExpect(model().attribute("autos", hasItem(
                        allOf(
                                hasProperty("marca", is("Fiat")),
                                hasProperty("modello", is("Panda")),
                                hasProperty("cilindrata", is("1.0")),
                                hasProperty("cavalli", is("1.0")),
                                hasProperty("coppia", is("1.0")),
                                hasProperty("colore", is("nero"))
                        )
                )))
                .andExpect(model().attribute("autos", hasItem(
                        allOf(
                                hasProperty("marca", is("Fiat")),
                                hasProperty("modello", is("Bravo")),
                                hasProperty("cilindrata", is("1.0")),
                                hasProperty("cavalli", is("1.0")),
                                hasProperty("coppia", is("1.0")),
                                hasProperty("colore", is("bianco"))
                        )
                )));

        verify(autoService, times(1)).loadAutos();
        verifyNoMoreInteractions(autoService);

    }

}