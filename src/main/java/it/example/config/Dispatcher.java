package it.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Dispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override   //indica quale/i classe/i inizializzano il dispatcher e i bean associati
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    @Override   //indica quali requests va a gestire
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
