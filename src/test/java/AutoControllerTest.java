//import it.example.controllers.AutoController;
//import it.example.dao.AutoDAO;
//import it.example.model.Auto;
//import it.example.service.AutoService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import java.util.Arrays;
//import java.util.List;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(AutoController.class)
//@SpringBootTest(classes = {AutoController.class})
//public class AutoControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @Mock
//    private AutoDAO autoDAO;
//    @Mock
//    private AutoService autoService;
//    @InjectMocks
//    private AutoController autoController;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testOnLaunchGet() throws Exception {
//        Auto auto1 = new Auto();
//        Auto auto2 = new Auto();
//        auto1.setId(1);
//        auto1.setMarca("marca1");
//        auto1.setModello("modello1");
//        auto1.setCilindrata(123.0);
//        auto1.setCavalli(123.0);
//        auto1.setCoppia(123.0);
//        auto1.setColore("colore1");
//
//        auto2.setId(2);
//        auto2.setMarca("marca2");
//        auto2.setModello("modello2");
//        auto2.setCilindrata(123.0);
//        auto2.setCavalli(123.0);
//        auto2.setCoppia(123.0);
//        auto2.setColore("colore2");
//        List<Auto> autos = Arrays.asList(auto1, auto2);
//
//        when(autoService.loadAutos()).thenReturn(autos);
//
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("list_autos"))
//                .andExpect(model().attribute("loadedAutos", autos));
//
//        verify(autoService, times(1)).loadAutos();
//    }
//}
