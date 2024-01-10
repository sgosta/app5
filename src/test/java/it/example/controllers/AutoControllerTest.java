package it.example.controllers;

import it.example.config.AppConfig;
import it.example.config.Dispatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, Dispatcher.class })
public class AutoControllerTest {


    private AutoController controller = new AutoController();

    @Test
    public void testShowAutos() throws Exception {

    }
}