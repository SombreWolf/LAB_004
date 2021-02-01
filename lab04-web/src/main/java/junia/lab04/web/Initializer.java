package junia.lab04.web;

import junia.lab04.core.config.AppConfig;
import junia.lab04.core.config.DBConfig;
import junia.lab04.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        AppConfig appConfig = new AppConfig();
        DBConfig dbConfig = new DBConfig();
        Class[] rootConfigClasses = new Class[2];
        return rootConfigClasses;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        WebConfig webConfig = new WebConfig();
        Class[] servletConfigClasses = new Class[1];
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] servletMapping = new String[1];
        servletMapping[0] = "/";
        return servletMapping;
    }
}
