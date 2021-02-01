package junia.lab04.web;

import junia.lab04.core.config.AppConfig;
import junia.lab04.core.config.DBConfig;
import junia.lab04.web.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class[] rootConfigClasses = new Class[2];
        rootConfigClasses[0] = AppConfig.class;
        rootConfigClasses[1] = DBConfig.class;
        return rootConfigClasses;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] servletConfigClasses = new Class[1];
        servletConfigClasses[0] = WebConfig.class;
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] servletMapping = new String[1];
        servletMapping[0] = "/";
        return servletMapping;
    }
}
